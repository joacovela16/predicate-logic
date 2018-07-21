package jvc.predicate.logic.modules;

import jvc.predicate.engine.PredicateLogic;
import jvc.predicate.engine.type.PLTypeFactory;
import jvc.predicate.logic.utils.PLTestUtil;
import org.junit.Test;

public class ErrorTest {

    @Test
    public void test1() {

        PredicateLogic predicateLogic = new PredicateLogic();

        predicateLogic.add("A", PLTypeFactory.add(10, 11, 12));

        PLTestUtil.test(true, predicateLogic, "forall {a: A a >= 5");
    }

}
