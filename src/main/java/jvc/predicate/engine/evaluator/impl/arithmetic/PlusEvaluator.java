package jvc.predicate.engine.evaluator.impl.arithmetic;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.Evaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.types.PLType;
import jvc.predicate.engine.types.impl.PLAtomic;
import jvc.predicate.engine.types.impl.PLFloat;
import jvc.predicate.engine.types.impl.PLInt;
import jvc.predicate.engine.types.impl.PLString;

public class PlusEvaluator<L extends PLAtomic<?>, R extends PLAtomic<?>> extends BinaryEvaluator<L, R, PLAtomic<?>> {

    public PlusEvaluator() {
    }

    public PlusEvaluator(Evaluator<L> left, Evaluator<R> right) throws Exception {
        super(left, right);
    }

    @Override
    public EvaluatorResult<PLAtomic<?>> run() {

        EvaluatorResult<L> leftResult = getLeft();
        EvaluatorResult<R> rightResult = getRight();

        L left = leftResult.getData();
        R right = rightResult.getData();

        PLAtomic<?> result;

        switch (left.getType()) {

            case PLType.BOOLEAN:
            case PLType.INT:

                Integer leftInt = left.is(PLType.BOOLEAN) ? (left.toBool().getData() ? 1 : 0) : left.toInt().getData();

                switch (right.getType()) {
                    case PLType.BOOLEAN:

                        result = new PLInt(leftInt + (right.toBool().getData() ? 1 : 0));

                        break;
                    case PLType.INT:

                        result = new PLInt(leftInt + right.toInt().getData());

                        break;

                    case PLType.FLOAT:

                        result = new PLFloat(leftInt + right.toFloat().getData());

                        break;

                    default: // string

                        result = new PLString(leftInt + right.toStr().getData());

                        break;
                }

                break;

            case PLType.FLOAT:

                Float leftFloat = left.toFloat().getData();

                switch (right.getType()) {
                    case PLType.BOOLEAN:

                        result = new PLFloat(leftFloat + (right.toBool().getData() ? 1 : 0));

                        break;
                    case PLType.INT:

                        result = new PLFloat(leftFloat + right.toInt().getData());

                        break;

                    case PLType.FLOAT:

                        result = new PLFloat(leftFloat + right.toFloat().getData());

                        break;

                    default: // string

                        result = new PLString(leftFloat + right.toStr().getData());

                        break;
                }

                break;

            default: // string

                String leftStr = left.toStr().getData();

                switch (right.getType()) {
                    case PLType.BOOLEAN:

                        result = new PLString(leftStr + (right.toBool().getData() ? 1 : 0));

                        break;
                    case PLType.INT:

                        result = new PLString(leftStr + right.toInt().getData());

                        break;

                    case PLType.FLOAT:

                        result = new PLString(leftStr + right.toFloat().getData());

                        break;

                    default: // string

                        result = new PLString(leftStr + right.toStr().getData());

                        break;
                }

                break;
        }

        return new EvaluatorResult<>(result);
    }
}
