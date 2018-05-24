package jvc.predicate.engine.evaluator.impl.runtime;

import jvc.predicate.engine.evaluator.AtomicEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.types.PLType;

public class VariableEvaluator extends AtomicEvaluator<PLType<?>> {

    public VariableEvaluator(PLType<?> data) {
        super(data);
    }

    @Override
    public EvaluatorResult<PLType<?>> run() {
        return new EvaluatorResult<>(getData());
    }
}
