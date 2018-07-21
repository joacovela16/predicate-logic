package jvc.predicate.engine.evaluator.impl.arithmetic;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.type.PLOperator;
import jvc.predicate.engine.type.PLUtil;

public class PlusEvaluator<L, R> extends BinaryEvaluator<L, R, Object> {

    public PlusEvaluator() {

        PLOperator<EvaluatorResult<Object>> operator = getOperator();

        operator.setNr2Nr((a, b) -> {

            if (b.floatValue() == 0f) {
                return new EvaluatorResult<>("Operación no permitida.");
            }

            if (PLUtil.is(a, Float.class) || PLUtil.is(b, Float.class)) {
                float v = a.floatValue();
                float v1 = b.floatValue();
                return new EvaluatorResult<>(v + v1);
            } else {
                int i = a.intValue();
                int i1 = b.intValue();
                return new EvaluatorResult<>(i + i1);
            }
        });

        operator.setNr2Str((a, b) -> new EvaluatorResult<>(a + b));
        operator.setBool2Bool((a, b) -> new EvaluatorResult<>((a ? 1 : 0) + (b ? 1 : 0)));
        operator.setStr2Str((a, b) -> new EvaluatorResult<>(a + b));

        operator.setDefaultAction(() -> new EvaluatorResult<>("Operación no permitida."));

    }

}
