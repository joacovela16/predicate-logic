package jvc.predicate.engine.evaluator.impl.arithmetic;

import jvc.predicate.engine.evaluator.BinaryEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.type.PLOperator;

public class DivEvaluator<L, R> extends BinaryEvaluator<L, R, Number> {

    public DivEvaluator() {

        PLOperator<EvaluatorResult<Number>> operator = getOperator();

        operator.setNr2Nr((a, b) -> {
            float floatValue = b.floatValue();
            return floatValue == 0f ? new EvaluatorResult<>("División entre cero") : new EvaluatorResult<>(a.floatValue() / floatValue);
        });

        operator.setDefaultAction(() -> new EvaluatorResult<>("Operación no soportada"));

    }

}
