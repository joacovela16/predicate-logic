package jvc.predicate.engine.evaluator.impl.quantifier;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.evaluator.MultiEvaluator;
import jvc.predicate.engine.type.PLUtil;

import java.util.List;

public class ExistEvaluator extends MultiEvaluator {

    public ExistEvaluator(List<String> variablesName, List<String> setsName, SymbolTable symbolTable) {

        super(variablesName, setsName, symbolTable);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected boolean isSuccess(EvaluatorResult<?> evaluator) {

        Object data = evaluator.getData();
        boolean aBoolean = PLUtil.is(data, Boolean.class);

        if (aBoolean) {
            return PLUtil.asBool(data);
        }

        return false;
    }

    @Override
    protected boolean isFailure(EvaluatorResult<?> evaluator) {

        return false;
    }

    @Override
    protected boolean afterAll() {

        return false;
    }
}
