package jvc.predicate.engine.evaluator.impl.logic;

import jvc.predicate.engine.evaluator.Evaluator;
import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.evaluator.SingleEvaluator;
import jvc.predicate.engine.types.impl.PLAtomic;
import jvc.predicate.engine.types.impl.PLBoolean;

import java.util.function.Function;

public class PredicateEvaluator<INPUT extends PLAtomic<?>> extends SingleEvaluator<INPUT, PLBoolean> {

    private Function<INPUT, Boolean> function;

    public PredicateEvaluator() {
    }

    public PredicateEvaluator(Evaluator<INPUT> data, Function<INPUT, Boolean> function) throws Exception {
        super(data);

        this.function = function;

        if (function == null) throw new Exception("Operador nulo.");
    }

    @Override
    public EvaluatorResult<PLBoolean> run() {

        EvaluatorResult<INPUT> evaluatorResult = getEvaluator();

        INPUT data = evaluatorResult.getData();

        return new EvaluatorResult<>(new PLBoolean(function.apply(data)));
    }
}
