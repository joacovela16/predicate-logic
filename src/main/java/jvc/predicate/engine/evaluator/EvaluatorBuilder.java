package jvc.predicate.engine.evaluator;

import jvc.predicate.engine.evaluator.impl.arithmetic.PlusEvaluator;
import jvc.predicate.engine.evaluator.impl.comparation.*;
import jvc.predicate.engine.evaluator.impl.logic.AndEvaluator;
import jvc.predicate.engine.evaluator.impl.logic.NotEvaluator;
import jvc.predicate.engine.evaluator.impl.logic.OrEvaluator;
import jvc.predicate.engine.evaluator.impl.runtime.VariableEvaluator;
import jvc.predicate.engine.types.PLType;

import java.util.function.BinaryOperator;

public class EvaluatorBuilder {

    @SuppressWarnings("unchecked")
    public static BinaryEvaluator setRight(BinaryEvaluator binaryEvaluator, Evaluator e) {

        binaryEvaluator.setRight(e);
        return binaryEvaluator;
    }

    @SuppressWarnings("unchecked")
    public static BinaryEvaluator setLeft(BinaryEvaluator binaryEvaluator, Evaluator e) {

        binaryEvaluator.setLeft(e);
        return binaryEvaluator;

    }

    @SuppressWarnings("unchecked")
    public static Evaluator evalRight(BinaryEvaluator binaryEvaluator, Evaluator e) {

        if (binaryEvaluator == null)
            return e;

        binaryEvaluator.setRight(e);

        return binaryEvaluator;
    }

    @SuppressWarnings("unchecked")
    public static Evaluator evalLeft(BinaryEvaluator binaryEvaluator, Evaluator e) {

        if (binaryEvaluator == null)
            return e;

        binaryEvaluator.setLeft(e);

        return binaryEvaluator;
    }

    @SuppressWarnings("unchecked")
    public static Evaluator eval(SingleEvaluator singleEvaluator, Evaluator e) {

        if (singleEvaluator == null)
            return e;

        singleEvaluator.setEvaluator(e);

        return singleEvaluator;
    }

    public static Evaluator keepOne(Evaluator e1, Evaluator e2) {

        return e1 == null ? e2 : e1;
    }

    public static BinaryEvaluator keepBin(BinaryEvaluator b1, BinaryEvaluator b2) {

        return b1 == null ? b2 : b1;
    }

    public static VariableEvaluator eval(PLType a) {

        return new VariableEvaluator(a);
    }

    public static BinaryEvaluator andEval() {

        return new AndEvaluator();
    }

    public static BinaryEvaluator orEval() {

        return new OrEvaluator();
    }

    public static SingleEvaluator notEval() {

        return new NotEvaluator();
    }

    public static BinaryEvaluator plusEval() {

        return new PlusEvaluator();
    }

    public static BinaryEvaluator minusEval() {

        return new PlusEvaluator();
    }

    public static BinaryEvaluator timeEval() {

        return new PlusEvaluator();
    }

    public static BinaryEvaluator leEval() {

        return new LessEqualEvaluator();
    }

    public static BinaryEvaluator ltEval() {

        return new LessThanEvaluator();
    }

    public static BinaryEvaluator geEval() {

        return new GreatEqualEvaluator();
    }

    public static BinaryEvaluator gtEval() {

        return new GreatThanEvaluator();
    }

    public static BinaryEvaluator equalEval() {

        return new EqualEvaluator();
    }

    public static BinaryEvaluator notEqualEval() {

        return new NotEqualEvaluator();
    }
}
