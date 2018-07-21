package jvc.predicate.engine.evaluator;

public abstract class Evaluator<T> {

    protected abstract EvaluatorResult<T> run();

    public EvaluatorResult<T> eval() {

        return run();

    }

}
