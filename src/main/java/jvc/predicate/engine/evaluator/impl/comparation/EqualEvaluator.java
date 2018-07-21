package jvc.predicate.engine.evaluator.impl.comparation;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.type.PLOperator;
import jvc.predicate.engine.type.PLUtil;

import java.util.Objects;

public class EqualEvaluator<L, R> extends BinaryEvaluator<L, R, Boolean> {

    public EqualEvaluator() {

        PLOperator<EvaluatorResult<Boolean>> operator = getOperator();

        operator.setNr2Bool((a, b) -> new EvaluatorResult<>(a != null && Objects.equals(a, b ? 1 : 0)));
        operator.setNr2Nr((a, b) -> {

            if (PLUtil.is(a, Float.class) || PLUtil.is(b, Float.class)) {
                return new EvaluatorResult<>(a.floatValue() == b.floatValue());
            }

            return new EvaluatorResult<>(a.intValue() == b.intValue());
        });

        operator.setStr2Str((a, b) -> new EvaluatorResult<>(a.compareTo(b) == 0));

        operator.setBool2Bool((a, b) -> new EvaluatorResult<>(a.compareTo(b) == 0));
        operator.setBool2Nr((a, b) -> new EvaluatorResult<>(a != null && Objects.equals(b, a ? 1 : 0)));

        operator.setDefaultAction(() -> new EvaluatorResult<>(false));
    }

}
