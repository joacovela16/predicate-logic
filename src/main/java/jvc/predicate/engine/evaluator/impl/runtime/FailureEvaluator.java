package jvc.predicate.engine.evaluator.impl.runtime;

import jvc.predicate.engine.evaluator.Evaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;

public class FailureEvaluator extends Evaluator<Exception> {

    private String message;

    public FailureEvaluator(String message) {

        this.message = message;
    }

    public FailureEvaluator(Exception exception) {

        this.message = exception.getMessage();
    }

    @Override
    protected EvaluatorResult<Exception> run() {

        return new EvaluatorResult<>(message);
    }
}
