package jvc.predicate.engine.evaluator.impl.quantifier;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.evaluator.MultiEvaluator;
import jvc.predicate.engine.type.PLUtil;

import java.util.List;

public class ForallEvaluator extends MultiEvaluator {

    public ForallEvaluator(List<String> variablesName, List<String> setsName, SymbolTable symbolTable) {

        super(variablesName, setsName, symbolTable);
    }

    @Override
    protected boolean isSuccess(EvaluatorResult<?> evaluator) {

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected boolean isFailure(EvaluatorResult<?> evaluator) {

        Object data = evaluator.getData();
        boolean aBoolean = PLUtil.is(data, Boolean.class);

        if (aBoolean) {

            Boolean booleanData = PLUtil.asBool(data);

            return !booleanData;
        }

        return false;
    }

    @Override
    protected boolean afterAll() {

        return true;
    }
}
