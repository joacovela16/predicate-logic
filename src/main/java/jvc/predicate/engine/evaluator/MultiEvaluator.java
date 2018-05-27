package jvc.predicate.engine.evaluator;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.types.PLType;
import jvc.predicate.engine.types.PLTypeFactory;
import jvc.predicate.engine.types.impl.PLBoolean;
import jvc.predicate.engine.types.impl.PLCollection;

import java.util.Collection;
import java.util.List;

public abstract class MultiEvaluator extends Evaluator<PLBoolean> {

    private List<String> variablesName;
    private List<String> setsName;
    private SymbolTable symbolTable;
    private int variablesLg;
    private Evaluator<PLType<?>> evaluator;

    public MultiEvaluator(List<String> variablesName, List<String> setsName, SymbolTable symbolTable) {

        this.variablesName = variablesName;
        this.setsName = setsName;
        this.symbolTable = symbolTable;
    }

    protected abstract boolean isSuccess(EvaluatorResult<PLType<?>> evaluator);

    protected abstract boolean isFailure(EvaluatorResult<PLType<?>> evaluator);

    protected abstract boolean afterAll();

    public void setEvaluator(Evaluator<PLType<?>> evaluator) {

        this.evaluator = evaluator;
    }

    @Override
    protected EvaluatorResult<PLBoolean> run() {

        if (variablesName == null || setsName == null || symbolTable == null) {
            return new EvaluatorResult<>("Faltan datos requeridos");
        }

        if (setsName.size() != variablesName.size()) {
            return new EvaluatorResult<>("Largo de variables no coincide con el de conjuntos");
        }

        this.variablesLg = variablesName.size() - 1;

        boolean variablesNoDefined = variablesName.stream().allMatch(x -> symbolTable.getVariable(x) == null);

        if (!variablesNoDefined) {
            return new EvaluatorResult<>("Existen variables con el mismo nombre.");
        }

        boolean setDefined = setsName.stream().allMatch(x -> symbolTable.getVariable(x).is(PLType.COLLECTION));

        if (!setDefined) {
            return new EvaluatorResult<>("Una de las variables no es un conjunto.");
        }

        return runner(0);
    }

    private EvaluatorResult<PLBoolean> runner(int idx) {

        PLType<?> value;
        EvaluatorResult<PLType<?>> evaluatorResult;

        String variableKey = variablesName.get(idx);
        String setKey = setsName.get(idx);

        PLCollection<?> plCollection = symbolTable.getVariable(setKey).toCollection();

        int nextIdx = idx + 1;

        Collection<?> collection = plCollection.getData();
        if (idx < variablesLg) {

            for (Object datum : collection) {
                value = PLTypeFactory.test(datum);

                if (value == null) {
                    return new EvaluatorResult<>("Error interno, valor nulo.");
                }

                symbolTable.forceAddVariable(variableKey, value);
                EvaluatorResult<PLBoolean> result = runner(nextIdx);

                if (!result.getData().getData()) {
                    return result;
                }
            }

            return new EvaluatorResult<>(PLTypeFactory.add(true));

        } else if (idx == variablesLg) {

            for (Object datum : collection) {
                value = PLTypeFactory.test(datum);

                if (value == null) {
                    return new EvaluatorResult<>("Error interno, valor nulo.");
                }

                symbolTable.forceAddVariable(variableKey, value);

                evaluatorResult = evaluator.eval();

                if (isSuccess(evaluatorResult)) {
                    return new EvaluatorResult<>(PLTypeFactory.add(true));
                } else if (isFailure(evaluatorResult)) {
                    return new EvaluatorResult<>(PLTypeFactory.add(false));
                }
            }

            return new EvaluatorResult<>(PLTypeFactory.add(afterAll()));
        }

        return new EvaluatorResult<>("Error al ejecutar MultaEvaluator.");
    }

}
