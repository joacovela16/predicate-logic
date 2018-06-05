package jvc.predicate.engine.evaluator.impl.runtime;

import jvc.predicate.engine.evaluator.Evaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;

import java.util.ArrayList;
import java.util.List;

public class ArgumentEvaluator extends Evaluator<List<?>> {

    private List<Evaluator<?>> arguments;

    public ArgumentEvaluator() {

        arguments = new ArrayList<>();
    }

    public void add(Evaluator<?> evaluator) {

        arguments.add(evaluator);
    }

    @Override
    protected EvaluatorResult<List<?>> run() {

        List<Object> data = new ArrayList<>();

        EvaluatorResult<?> evaluatorResult;

        for (Evaluator<?> argument : arguments) {
            evaluatorResult = argument.eval();
            if (evaluatorResult.isSuccess()) {
                data.add(evaluatorResult.getData());
            } else {
                return new EvaluatorResult<>(evaluatorResult.getMessage());
            }
        }

        return new EvaluatorResult<>(data);
    }
}
