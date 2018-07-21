package jvc.predicate.engine.evaluator.impl.conditional;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.type.PLOperator;

public class BiConditionalOperator extends BinaryEvaluator<Boolean, Boolean, Boolean> {

    public BiConditionalOperator() {

        PLOperator<EvaluatorResult<Boolean>> operator = getOperator();

        operator.setBool2Bool((a, b) -> new EvaluatorResult<>(a == b));

        operator.setDefaultAction(() -> new EvaluatorResult<>("Operación no soportada"));
    }
}
