package jvc.predicate.engine.evaluator.impl.logic;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;

public class OrEvaluator extends BinaryEvaluator<Boolean, Boolean, Boolean> {

    public OrEvaluator() {

    }

    @Override
    public EvaluatorResult<Boolean> run() {

        EvaluatorResult<Boolean> leftEvaluator = getLeft();
        EvaluatorResult<Boolean> rightEvaluator = getRight();

        if (leftEvaluator.isFailure()) {
            return leftEvaluator;
        }

        if (rightEvaluator.isFailure()) {
            return rightEvaluator;
        }

        Boolean left = leftEvaluator.getData();
        Boolean right = rightEvaluator.getData();

        return new EvaluatorResult<>(left || right);
    }
}
