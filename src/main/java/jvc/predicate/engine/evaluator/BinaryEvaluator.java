package jvc.predicate.engine.evaluator;

import jvc.predicate.engine.type.PLOperator;

public abstract class BinaryEvaluator<L, R, T> extends Evaluator<T> {

    private Evaluator<L> left;
    private Evaluator<R> right;
    private PLOperator<EvaluatorResult<T>> operator;

    public BinaryEvaluator() {

        operator = new PLOperator<>();
    }

    public PLOperator<EvaluatorResult<T>> getOperator() {

        return operator;
    }

    @Override
    protected EvaluatorResult<T> run() {

        EvaluatorResult<L> leftResult = getLeft();
        EvaluatorResult<R> rightResult = getRight();

        L left = leftResult.getData();
        R right = rightResult.getData();

        return operator.process(left, right);
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
