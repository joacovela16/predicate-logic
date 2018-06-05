package jvc.predicate.engine.evaluator.impl.logic;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;

public class AndEvaluator extends BinaryEvaluator<Boolean, Boolean, Boolean> {

    public AndEvaluator() {

    }

    @Override
    public EvaluatorResult<Boolean> run() {

        EvaluatorResult<Boolean> leftEvaluator = getLeft();
        EvaluatorResult<Boolean> rightEvaluator = getRight();

        Boolean left = leftEvaluator.getData();
        Boolean right = rightEvaluator.getData();

        return new EvaluatorResult<>(left && right);
    }
}
