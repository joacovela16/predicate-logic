package jvc.predicate.logic.modules;

import jvc.predicate.engine.PredicateLogic;
import jvc.predicate.engine.type.PLTypeFactory;
import jvc.predicate.logic.utils.PLTestUtil;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;

public class FunctionTest {

    @Test
    public void test1() {

        PredicateLogic predicateLogic = new PredicateLogic();

        predicateLogic.add("sum", sumOperator());

        PLTestUtil.test(false, predicateLogic, "  sum(2, 3) == 4");

    }

    @Test
    public void test2() {

        PredicateLogic predicateLogic = new PredicateLogic();

        predicateLogic.add("sum", sumOperator());

        PLTestUtil.test(true, predicateLogic, "  sum(2, 2) == 4");

    }

    @Test
    public void test3() {

        PredicateLogic predicateLogic = new PredicateLogic();

        predicateLogic.add("lessThan", lessThanOperator());

        predicateLogic.add("sum", sumOperator());

        PLTestUtil.test(true, predicateLogic, "  lessThan( sum(2, sum(1, 1)), 5)  ");

    }

    @Test
    public void test4() {

        PredicateLogic predicateLogic = new PredicateLogic();

        predicateLogic.add("A", PLTypeFactory.add(10, 11, 12));

        predicateLogic.add("lessThan", lessThanOperator());

        PLTestUtil.test(true, predicateLogic, " forall {a: A} lessThan(5, a)");
    }

    private Function<Object[], Optional<Boolean>> lessThanOperator() {

        return e -> {

            if (e.length == 2 && e[0] instanceof Integer && e[1] instanceof Integer) {
                Integer e1 = (Integer) e[0];
                Integer e2 = (Integer) e[1];

                return Optional.of(e1 < e2);
            }
            return Optional.empty();
        };
    }

    private Function<Object[], Optional<Integer>> sumOperator() {

        return e -> {

            if (e.length == 2 && e[0] instanceof Integer && e[1] instanceof Integer) {
                Integer e1 = (Integer) e[0];
                Integer e2 = (Integer) e[1];

                return Optional.of(e1 + e2);
            }
            return Optional.empty();
        };
    }
}
