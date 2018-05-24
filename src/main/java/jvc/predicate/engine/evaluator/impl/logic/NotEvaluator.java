package jvc.predicate.engine.evaluator.impl.logic;

import jvc.predicate.engine.evaluator.Evaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.evaluator.SingleEvaluator;
import jvc.predicate.engine.types.impl.PLBoolean;

public class NotEvaluator extends SingleEvaluator<PLBoolean, PLBoolean> {

    public NotEvaluator() {
    }

    public NotEvaluator(Evaluator<PLBoolean> data) throws Exception {
        super(data);
    }

    @Override
    public EvaluatorResult<PLBoolean> run() {

        EvaluatorResult<PLBoolean> evaluator = getEvaluator();
        PLBoolean data = evaluator.getData();

        return new EvaluatorResult<>(new PLBoolean(!data.getData()));
    }
}
