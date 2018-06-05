package jvc.predicate.engine.evaluator.impl.comparation;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.type.PLOperator;

public class LessThanEvaluator<L, R> extends BinaryEvaluator<L, R, Boolean> {

    public LessThanEvaluator() {

        PLOperator<EvaluatorResult<Boolean>> operator = getOperator();

        operator.setNr2Bool((a, b) -> new EvaluatorResult<>(a != null && a.floatValue() < (b ? 1 : 0)));
        operator.setNr2Nr((a, b) -> new EvaluatorResult<>(a.floatValue() < b.floatValue()));

        operator.setStr2Str((a, b) -> new EvaluatorResult<>(a.compareTo(b) < 0));

        operator.setBool2Bool((a, b) -> new EvaluatorResult<>(a.compareTo(b) < 0));
        operator.setBool2Nr((a, b) -> new EvaluatorResult<>((a ? 1 : 0) < b.floatValue()));

        operator.setDefaultAction(() -> new EvaluatorResult<>("Operación no soportada."));
    }

}
