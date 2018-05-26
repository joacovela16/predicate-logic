package jvc.predicate.engine;

import jvc.predicate.engine.evaluator.EvaluatorResult;
import jvc.predicate.engine.types.PLType;

public class PredicateLogic {

    private EvaluatorResult<PLType<?>> evaluatorResult;
//    private Logger logger = LoggerFactory.getLogger(PredicateLogic.class);

    public void setEvaluatorResult(EvaluatorResult<PLType<?>> evaluatorResult) {

        this.evaluatorResult = evaluatorResult;
    }

    public boolean isSuccesfull() {

        return evaluatorResult != null && evaluatorResult.isSuccess();
    }

    public Object getResult() {
        return evaluatorResult == null ? null : evaluatorResult.getData().getData();
    }

    public void displayInfo() {

        if (evaluatorResult != null) {
            System.out.println(evaluatorResult.toString());
        }
    }
}
