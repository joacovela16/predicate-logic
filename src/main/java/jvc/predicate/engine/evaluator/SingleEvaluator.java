package jvc.predicate.engine.evaluator;

public abstract class SingleEvaluator<L, T> extends Evaluator<T> {

    private Evaluator<L> evaluator;

    public SingleEvaluator() {

    }

    public SingleEvaluator(Evaluator<L> evaluator) {

        this.evaluator = evaluator;
    }

    public void setEvaluator(Evaluator<L> evaluator) {

        this.evaluator = evaluator;
    }

    public EvaluatorResult<L> getEvaluator() {

        return evaluator.run();
    }

}
