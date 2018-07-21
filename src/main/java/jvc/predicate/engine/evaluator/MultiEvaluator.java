package jvc.predicate.engine.evaluator;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.type.PLUtil;

import java.util.Collection;
import java.util.List;

public abstract class MultiEvaluator extends Evaluator<Boolean> {

    private List<String> variablesName;
    private List<String> setsName;
    private SymbolTable symbolTable;
    private int variablesLg;
    private Evaluator<?> evaluator;

    public MultiEvaluator(List<String> variablesName, List<String> setsName, SymbolTable symbolTable) {

        this.variablesName = variablesName;
        this.setsName = setsName;
        this.symbolTable = symbolTable;
    }

    protected abstract boolean isSuccess(EvaluatorResult<?> evaluator);

    protected abstract boolean isFailure(EvaluatorResult<?> evaluator);

    protected abstract boolean afterAll();

    public void setEvaluator(Evaluator<?> evaluator) {

        this.evaluator = evaluator;
    }

    @Override
    protected EvaluatorResult<Boolean> run() {

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

        boolean setDefined = setsName.stream().allMatch(x -> PLUtil.isCollection(symbolTable.getVariable(x)));

        if (!setDefined) {
            return new EvaluatorResult<>("Una de las variables no es un conjunto.");
        }

        EvaluatorResult<Boolean> runner = runner(0);

        for (String var : variablesName) {
            symbolTable.removeVariable(var);
        }

        return runner;
    }

    private EvaluatorResult<Boolean> runner(int idx) {

        EvaluatorResult<?> evaluatorResult;

        String variableKey = variablesName.get(idx);
        String setKey = setsName.get(idx);

        Collection<?> collection = PLUtil.asCollection(symbolTable.getVariable(setKey));

        if (collection == null)
            return new EvaluatorResult<>("Sin datos para procesar");

        int nextIdx = idx + 1;

        if (idx < variablesLg) {

            for (Object value : collection) {

                symbolTable.forceAddVariable(variableKey, value);
                EvaluatorResult<Boolean> result = runner(nextIdx);

                if (!result.getData()) {
                    return result;
                }
            }

            return new EvaluatorResult<>(true);

        } else if (idx == variablesLg) {

            for (Object value : collection) {

                symbolTable.forceAddVariable(variableKey, value);

                evaluatorResult = evaluator.eval();

                if (isSuccess(evaluatorResult)) {
                    return new EvaluatorResult<>(true);
                } else if (isFailure(evaluatorResult)) {
                    return new EvaluatorResult<>(false);
                }
            }

            return new EvaluatorResult<>(afterAll());
        }

        return new EvaluatorResult<>("Error al ejecutar MultaEvaluator.");
    }

}
