package jvc.predicate.engine.evaluator.impl.runtime;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.evaluator.MultiEvaluator;
import jvc.predicate.engine.types.PLType;
import jvc.predicate.engine.types.impl.PLBoolean;

import java.util.List;

public class ExistEvaluator extends MultiEvaluator {

    public ExistEvaluator(List<String> variablesName, List<String> setsName, SymbolTable symbolTable) {

        super(variablesName, setsName, symbolTable);
    }

    @Override
    protected boolean isSuccess(EvaluatorResult<PLType<?>> evaluator) {

        PLType<?> data = evaluator.getData();
        boolean aBoolean = data.is(PLType.BOOLEAN);

        if (aBoolean) {
            PLBoolean plBoolean = data.toBool();
            return plBoolean.getData();
        }

        return false;
    }

    @Override
    protected boolean isFailure(EvaluatorResult<PLType<?>> evaluator) {

        return false;
    }

    @Override
    protected boolean afterAll() {

        return false;
    }
}
