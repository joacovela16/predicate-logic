package jvc.predicate.engine.evaluator.impl.runtime;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.evaluator.Evaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.types.PLType;

public class VariableEvaluator extends Evaluator<PLType<?>> {

    private String variableName;
    private SymbolTable symbolTable;

    public VariableEvaluator(String variableName, SymbolTable symbolTable) {

        this.variableName = variableName;

        this.symbolTable = symbolTable;
    }

    @Override
    protected EvaluatorResult<PLType<?>> run() {

        if (symbolTable == null || variableName == null) {
            return new EvaluatorResult<>("Faltan datos");
        }

        PLType<?> variable = symbolTable.getVariable(variableName);

        if (variable == null) {
            return new EvaluatorResult<>("No existe variable " + variableName);
        }

        TypeEvaluator typeEvaluator = new TypeEvaluator(variable);

        return typeEvaluator.eval();
    }

}
