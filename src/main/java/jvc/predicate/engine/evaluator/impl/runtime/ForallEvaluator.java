package jvc.predicate.engine.evaluator.impl.runtime;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.evaluator.MultiEvaluator;
import jvc.predicate.engine.types.PLType;

import java.util.List;

public class ForallEvaluator extends MultiEvaluator {

    public ForallEvaluator(List<String> variablesName, List<String> setsName, SymbolTable symbolTable) {

        super(variablesName, setsName, symbolTable);
    }

    @Override
    protected boolean isSuccess(EvaluatorResult<PLType<?>> evaluator) {
        return false;
    }

    @Override
    protected boolean isFailure(EvaluatorResult<PLType<?>> evaluator) {

        PLType<?> data = evaluator.getData();
        boolean aBoolean = data.is(PLType.BOOLEAN);

        if (aBoolean){
            return !data.toBool().getData();
        }

        return false;
    }

    @Override
    protected boolean afterAll() {

        return true;
    }
}
