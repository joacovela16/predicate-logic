package jvc.predicate.engine.evaluator.impl.logic;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.Evaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.types.impl.PLBoolean;

public class OrEvaluator extends BinaryEvaluator<PLBoolean, PLBoolean, PLBoolean> {

    public OrEvaluator() {
    }

    public OrEvaluator(Evaluator<PLBoolean> left, Evaluator<PLBoolean> right) throws Exception {
        super(left, right);
    }

    @Override
    public EvaluatorResult<PLBoolean> run() {

        EvaluatorResult<PLBoolean> leftEvaluator = getLeft();
        EvaluatorResult<PLBoolean> rightEvaluator = getRight();

        PLBoolean left = leftEvaluator.getData();
        PLBoolean right = rightEvaluator.getData();

        return new EvaluatorResult<>(new PLBoolean(left.getData() || right.getData()));
    }
}
