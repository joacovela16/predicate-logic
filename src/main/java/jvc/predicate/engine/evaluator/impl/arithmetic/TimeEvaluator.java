package jvc.predicate.engine.evaluator.impl.arithmetic;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.type.PLOperator;
import jvc.predicate.engine.type.PLUtil;

public class TimeEvaluator<L, R> extends BinaryEvaluator<L, R, Number> {

    public TimeEvaluator() {

        PLOperator<EvaluatorResult<Number>> operator = getOperator();

        operator.setNr2Nr((a, b) -> {

            if (b.floatValue() == 0f) {
                return new EvaluatorResult<>("Operación no permitida.");
            }

            if (PLUtil.is(a, Float.class) || PLUtil.is(b, Float.class)) {
                float v = a.floatValue();
                float v1 = b.floatValue();
                return new EvaluatorResult<>(v * v1);
            } else {
                int i = a.intValue();
                int i1 = b.intValue();
                return new EvaluatorResult<>(i * i1);
            }
        });

    }

}
