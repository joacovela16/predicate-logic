package jvc.predicate.engine;

import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.types.PLType;
import jvc.predicate.engine.types.impl.PLBoolean;
import jvc.predicate.engine.types.impl.PLFloat;
import jvc.predicate.engine.types.impl.PLInt;

public class PredicateLogic {

    private EvaluatorResult<PLType<?>> evaluatorResult;
    private SymbolTable symbolTable;

    public void setEvaluatorResult(EvaluatorResult<PLType<?>> evaluatorResult) {

        this.evaluatorResult = evaluatorResult;
    }

    public SymbolTable getSymbolTable() {

        if (symbolTable == null) {
            symbolTable = new SymbolTable();
        }

        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {

        this.symbolTable = symbolTable;
    }

    /******** resultados de ejecucion ********/
    public boolean isSuccesfull() {

        return evaluatorResult != null && evaluatorResult.isSuccess();
    }

    public Object getResult() {

        return evaluatorResult == null ? null : evaluatorResult.getData().getData();
    }

    /******** metodos para agregar variables ********/

    public void add(String key, Integer value) {

        symbolTable.addVariable(key, new PLInt(value));
    }

    public void add(String key, Boolean value) {

        symbolTable.addVariable(key, new PLBoolean(value));
    }

    public void add(String key, Float value) {

        symbolTable.addVariable(key, new PLFloat(value));
    }

}
