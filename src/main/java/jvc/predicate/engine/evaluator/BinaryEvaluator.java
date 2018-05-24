package jvc.predicate.engine.evaluator;

public abstract class BinaryEvaluator<L , R , T > implements Evaluator<T> {

    private Evaluator<L> left;
    private Evaluator<R> right;

    public BinaryEvaluator() {
    }

    public BinaryEvaluator(Evaluator<L> left, Evaluator<R> right) throws Exception {

        this.left = left;
        this.right = right;

        if (left == null || right == null) throw new Exception("Operadores nulos");
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
