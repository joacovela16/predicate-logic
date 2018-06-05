package jvc.predicate.engine;

import jvc.predicate.engine.evaluator.EvaluatorResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;

public class PredicateLogic {

    private EvaluatorResult<?> evaluatorResult;
    private SymbolTable symbolTable;
    private List<String> errorTrace;

    public PredicateLogic() {

        errorTrace = new ArrayList<>();
    }

    public void setEvaluatorResult(EvaluatorResult<?> evaluatorResult) {

        this.evaluatorResult = evaluatorResult;
    }

    public void addErrorTrace(String msg) {

        errorTrace.add(msg);
    }

    public String getErrorTrace() {

        if (evaluatorResult == null) {
            StringJoiner stringJoiner = new StringJoiner("\n");
            for (String s : errorTrace) {
                stringJoiner.add(s);
            }
            return stringJoiner.toString();

        } else {
            return evaluatorResult.getMessage();
        }
    }

    public SymbolTable getSymbolTable() {

        if (symbolTable == null) {
            symbolTable = new SymbolTable();
        }

        return symbolTable;
    }

    public EvaluatorResult<?> getEvaluatorResult() {

        return evaluatorResult;
    }

    public void setSymbolTable(SymbolTable symbolTable) {

        this.symbolTable = symbolTable;
    }

    /******** resultados de ejecucion ********/
    public boolean isSuccess() {

        return errorTrace.isEmpty() && evaluatorResult != null && evaluatorResult.isSuccess();
    }

    public boolean isFailure() {

        return evaluatorResult == null || evaluatorResult.isFailure();
    }

    public Object getResult() {

        return evaluatorResult == null ? null : evaluatorResult.getData();
    }

    /******** metodos para agregar variables ********/

    public <A> void add(String key, Function<Object[], Optional<A>> aFunction) {

        getSymbolTable().addVariable(key, aFunction);
    }

    public <A> void add(String key, List<A> items) {

        getSymbolTable().addVariable(key, items);
    }

    public void add(String key, Integer value) {

        getSymbolTable().addVariable(key, value);
    }

    public void add(String key, Boolean value) {

        getSymbolTable().addVariable(key, value);
    }

    public void add(String key, Float value) {

        getSymbolTable().addVariable(key, value);
    }

}
