package jvc.predicate.engine.evaluator.impl.runtime;

import jvc.predicate.engine.evaluator.AtomicEvaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;

public class TypeEvaluator<T> extends AtomicEvaluator<T> {

    public TypeEvaluator(T data) {

        super(data);
    }

    @Override
    public EvaluatorResult<T> run() {
        return new EvaluatorResult<>(getData());
    }
}
