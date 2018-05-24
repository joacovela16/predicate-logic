package jvc.predicate.engine.evaluator;

import jvc.predicate.engine.evaluator.impl.runtime.VariableEvaluator;
import jvc.predicate.engine.types.PLType;

public class EvaluatorBuilder {


    public static VariableEvaluator variable(PLType<?> a){
        return new VariableEvaluator(a);
    }

    public static Evaluator binary(  AtomicEvaluator atomicEvaluator, BinaryEvaluator binaryEvaluator){
        if (binaryEvaluator==null)
            return atomicEvaluator;
        else
            binaryEvaluator.setLeft(atomicEvaluator);

        return binaryEvaluator;
    }

}
