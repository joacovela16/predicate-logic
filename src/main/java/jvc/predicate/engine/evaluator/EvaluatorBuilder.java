package jvc.predicate.engine.evaluator;

import com.sun.org.apache.xpath.internal.Arg;
import java_cup.runtime.ComplexSymbolFactory;
import jvc.predicate.engine.PredicateLogic;
import jvc.predicate.engine.evaluator.impl.arithmetic.*;
import jvc.predicate.engine.evaluator.impl.comparation.*;
import jvc.predicate.engine.evaluator.impl.conditional.BiConditionalOperator;
import jvc.predicate.engine.evaluator.impl.conditional.ConditionalOperator;
import jvc.predicate.engine.evaluator.impl.logic.AndEvaluator;
import jvc.predicate.engine.evaluator.impl.logic.NotEvaluator;
import jvc.predicate.engine.evaluator.impl.logic.OrEvaluator;
import jvc.predicate.engine.evaluator.impl.quantifier.ExistEvaluator;
import jvc.predicate.engine.evaluator.impl.quantifier.ForallEvaluator;
import jvc.predicate.engine.evaluator.impl.runtime.*;

import java.util.List;

public class EvaluatorBuilder {

    public static Evaluator keepOne(Evaluator a, Evaluator b) {

        return a == null ? b : a;
    }

    public static void addError(String msg, Object o, PredicateLogic predicateLogic) {

        if (o instanceof ComplexSymbolFactory.ComplexSymbol) {
            ComplexSymbolFactory.ComplexSymbol complexSymbol = (ComplexSymbolFactory.ComplexSymbol) o;

            int column = complexSymbol.getLeft().getColumn();
            int line = complexSymbol.getLeft().getLine();
            predicateLogic.addErrorTrace(String.format("%s linea %s, columna %s", msg, line, column));
        }
    }

    @SuppressWarnings("unchecked")
    public static Evaluator maybeFunction(Evaluator e1, Evaluator e2) {

        if (e1 == null || e2 == null) {
            return keepOne(e1, e2);
        } else if (e1 instanceof VariableEvaluator && e2 instanceof ArgumentEvaluator) {
            return new FunctionEvaluator((VariableEvaluator) e1, (ArgumentEvaluator) e2);
        }

        return new FailureEvaluator("Problemas al evaluar");
    }

    @SuppressWarnings("unchecked")
    public static Evaluator evalConditional(Evaluator a, Evaluator b) {

        ConditionalOperator conditionalOperator = new ConditionalOperator();

        conditionalOperator.setLeft(a);
        conditionalOperator.setRight(b);

        return conditionalOperator;
    }

    @SuppressWarnings("unchecked")
    public static Evaluator evalBiConditional(Evaluator a, Evaluator b) {

        BiConditionalOperator biConditionalOperator = new BiConditionalOperator();

        biConditionalOperator.setLeft(a);
        biConditionalOperator.setRight(b);

        return biConditionalOperator;
    }

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

    public static <T> Evaluator eval(String key, PredicateLogic predicateLogic) {

        return new VariableEvaluator<>(key, predicateLogic.getSymbolTable());
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

    public static <T> TypeEvaluator eval(T a) {

        return new TypeEvaluator<>(a);
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
