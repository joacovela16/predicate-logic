package jvc.predicate.engine.evaluator.impl.comparation;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.Evaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.types.PLType;
import jvc.predicate.engine.types.impl.PLAtomic;
import jvc.predicate.engine.types.impl.PLBoolean;

public class LessThanEvaluator<L extends PLAtomic<?>, R extends PLAtomic<?>> extends BinaryEvaluator<L, R, PLBoolean> {

    public LessThanEvaluator(Evaluator<L> left, Evaluator<R> right) throws Exception {
        super(left, right);
    }

    @Override
    public EvaluatorResult<PLBoolean> run() {

        EvaluatorResult<L> leftResult = getLeft();
        EvaluatorResult<R> rightResult = getRight();

        L left = leftResult.getData();
        R right = rightResult.getData();

        PLBoolean result;

        switch (left.getType()) {

            case PLType.BOOLEAN:
            case PLType.INT:
            case PLType.FLOAT:

                Integer leftInt = left.is(PLType.BOOLEAN) ? (left.toBool().getData() ? 1 : 0) : left.toInt().getData();

                switch (right.getType()) {
                    case PLType.BOOLEAN:

                        result = new PLBoolean(leftInt < (right.toBool().getData() ? 1 : 0));

                        break;
                    case PLType.INT:

                        result = new PLBoolean(leftInt < right.toInt().getData());

                        break;

                    case PLType.FLOAT:

                        result = new PLBoolean(leftInt < right.toFloat().getData());

                        break;

                    default: // string

                        result = new PLBoolean(false);

                        break;
                }

                break;

            default: // string

                String leftStr = left.toStr().getData();

                switch (right.getType()) {
                    case PLType.BOOLEAN:
                    case PLType.INT:
                    case PLType.FLOAT:

                        result = new PLBoolean(false);

                        break;

                    default: // string

                        result = new PLBoolean(leftStr.compareTo(right.toStr().getData()) < 0);

                        break;
                }
        }

        return new EvaluatorResult<>(result);
    }
}
