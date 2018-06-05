package jvc.predicate.engine.evaluator.impl.logic;

import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.evaluator.SingleEvaluator;

public class NotEvaluator extends SingleEvaluator<Boolean, Boolean> {

    public NotEvaluator() {

    }

    @Override
    public EvaluatorResult<Boolean> run() {

        EvaluatorResult<Boolean> evaluator = getEvaluator();
        Boolean data = evaluator.getData();

        return new EvaluatorResult<>(!data);
    }
}
