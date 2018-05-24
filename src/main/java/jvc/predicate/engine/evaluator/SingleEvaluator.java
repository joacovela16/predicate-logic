package jvc.predicate.engine.evaluator;

public abstract class SingleEvaluator<L, T> implements Evaluator<T> {

    private Evaluator<L> evaluator;

    public SingleEvaluator() {
    }

    public SingleEvaluator(Evaluator<L> evaluator) throws Exception {
        this.evaluator = evaluator;

        if (evaluator == null) throw new Exception("Operadores nulos");
    }

    public void setEvaluator(Evaluator<L> evaluator) {
        this.evaluator = evaluator;
    }

    public EvaluatorResult<L> getEvaluator() {
        return evaluator.run();
    }
}
