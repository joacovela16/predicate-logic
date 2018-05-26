package jvc.predicate.engine.evaluator;

public abstract class Evaluator<T> {

    public abstract boolean validate();

    protected abstract EvaluatorResult<T> run();

    public EvaluatorResult<T> eval() {

        return run();

    }
}
