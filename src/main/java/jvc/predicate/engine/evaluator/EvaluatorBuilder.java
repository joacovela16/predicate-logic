package jvc.predicate.engine.evaluator;

import jvc.predicate.engine.PredicateLogic;
import jvc.predicate.engine.evaluator.impl.arithmetic.*;
import jvc.predicate.engine.evaluator.impl.comparation.*;
import jvc.predicate.engine.evaluator.impl.logic.AndEvaluator;
import jvc.predicate.engine.evaluator.impl.logic.NotEvaluator;
import jvc.predicate.engine.evaluator.impl.logic.OrEvaluator;
import jvc.predicate.engine.evaluator.impl.runtime.ExistEvaluator;
import jvc.predicate.engine.evaluator.impl.runtime.ForallEvaluator;
import jvc.predicate.engine.evaluator.impl.runtime.TypeEvaluator;
import jvc.predicate.engine.evaluator.impl.runtime.VariableEvaluator;
import jvc.predicate.engine.types.PLType;

import java.util.List;

public class EvaluatorBuilder {

    @SuppressWarnings("unchecked")
    public static Evaluator evalForall(List<String> variablesName, List<String> setName, Evaluator e, PredicateLogic predicateLogic) {

        ForallEvaluator forallEvaluator = new ForallEvaluator(variablesName, setName, predicateLogic.getSymbolTable());
        forallEvaluator.setEvaluator(e);

        return forallEvaluator;
    }

    @SuppressWarnings("unchecked")
    public static Evaluator evalExist(List<String> variablesName, List<String> setName, Evaluator e, PredicateLogic predicateLogic) {

        ExistEvaluator existEvaluator = new ExistEvaluator(variablesName, setName, predicateLogic.getSymbolTable());
        existEvaluator.setEvaluator(e);

        return existEvaluator;
    }

    public static Evaluator eval(String key, PredicateLogic predicateLogic) {

        return new VariableEvaluator(key, predicateLogic.getSymbolTable());
    }

    @SuppressWarnings("unchecked")
    public static Evaluator eval(SingleEvaluator singleEvaluator, Evaluator e) {

        if (singleEvaluator == null)
            return e;

        singleEvaluator.setEvaluator(e);

        return singleEvaluator;
    }

    @SuppressWarnings("unchecked")
    public static Evaluator eval(Evaluator e1, BinaryEvaluator bin, Evaluator e2) {

        bin.setLeft(e1);
        bin.setRight(e2);
        return bin;
    }

    public static TypeEvaluator eval(PLType a) {

        return new TypeEvaluator(a);
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

    public static BinaryEvaluator divEval() {

        return new DivEvaluator();
    }

    public static BinaryEvaluator modEval() {

        return new ModEvaluator();
    }

    public static BinaryEvaluator minusEval() {

        return new MinusEvaluator();
    }

    public static BinaryEvaluator timeEval() {

        return new TimeEvaluator();
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
