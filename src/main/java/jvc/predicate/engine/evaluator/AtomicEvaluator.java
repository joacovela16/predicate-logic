package jvc.predicate.engine.evaluator;

public abstract class AtomicEvaluator<T> extends Evaluator<T> {

    private T data;

    public AtomicEvaluator() {

    }

    public AtomicEvaluator(T data) {

        this.data = data;
    }

    public T getData() {

        return data;
    }

}
