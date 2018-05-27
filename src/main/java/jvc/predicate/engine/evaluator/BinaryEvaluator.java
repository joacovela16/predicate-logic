package jvc.predicate.engine.evaluator;

public abstract class BinaryEvaluator<L, R, T> extends Evaluator<T> {

    private Evaluator<L> left;
    private Evaluator<R> right;

    public BinaryEvaluator() {

    }

    public BinaryEvaluator(Evaluator<L> left, Evaluator<R> right) {

        this.left = left;
        this.right = right;

    }


    public void setLeft(Evaluator<L> left) {

        this.left = left;
    }

    public void setRight(Evaluator<R> right) {

        this.right = right;
    }

    public EvaluatorResult<L> getLeft() {

        return left.run();
    }

    public EvaluatorResult<R> getRight() {

        return right.run();
    }

}
