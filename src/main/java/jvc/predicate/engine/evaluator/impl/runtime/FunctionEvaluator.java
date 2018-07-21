package jvc.predicate.engine.evaluator.impl.runtime;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.evaluator.AtomicEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FunctionEvaluator<T> extends AtomicEvaluator<T> {

    private final VariableEvaluator functionName;
    private final ArgumentEvaluator argumentEvaluator;

    public FunctionEvaluator(VariableEvaluator<?> functionName, ArgumentEvaluator argumentEvaluator) {

        this.functionName = functionName;
        this.argumentEvaluator = argumentEvaluator;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected EvaluatorResult<T> run() {

        SymbolTable symbolTable = functionName.getSymbolTable();
        String variableName = functionName.getVariableName();

        Object variable = symbolTable.getVariable(variableName);

        if (variable == null) {
            return new EvaluatorResult<>(String.format("La variable %s no existe.", variableName));
        }

        if (variable instanceof Function) {

            Function<Object[], Optional<T>> tFunction = (Function<Object[], Optional<T>>) variable;

            EvaluatorResult<List<?>> evaluatorResult = argumentEvaluator.eval();

            if (evaluatorResult.isFailure()) {
                return new EvaluatorResult<>(evaluatorResult.getMessage());
            }

            Object[] data = evaluatorResult.getData().toArray();
            Optional<T> optional = tFunction.apply(data);

            return optional.map(EvaluatorResult::new).orElseGet(() -> new EvaluatorResult<>("La función " + variableName + " no retornó ningún valor."));

        } else {
            return new EvaluatorResult<>("La variable " + variableName + " no es una función.");
        }

    }
}
