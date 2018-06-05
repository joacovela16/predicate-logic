package jvc.predicate.engine.evaluator.impl.runtime;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.evaluator.Evaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.type.PLUtil;

public class VariableEvaluator<T> extends Evaluator<T> {

    private String variableName;
    private SymbolTable symbolTable;

    public VariableEvaluator(String variableName, SymbolTable symbolTable) {

        this.variableName = variableName;
        this.symbolTable = symbolTable;
    }

    public String getVariableName() {

        return variableName;
    }

    public SymbolTable getSymbolTable() {

        return symbolTable;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected EvaluatorResult<T> run() {

        if (symbolTable == null || variableName == null) {
            return new EvaluatorResult<>("Faltan datos");
        }

        Object variable = symbolTable.getVariable(variableName);

        if (variable == null || !PLUtil.isValidType(variable)) {
            return new EvaluatorResult<>("No existe variable " + variableName);
        }

        TypeEvaluator<T> typeEvaluator = new TypeEvaluator<>((T) variable);

        return typeEvaluator.eval();
    }
}
