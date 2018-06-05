package jvc.predicate.logic;

import jvc.predicate.logic.modules.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArithmeticTest.class,
        ComparatorTest.class,
        LogicalTest.class,
        VariableTest.class,
        ForallTest.class,
        ExistTest.class,
        ConditionalTest.class,
        ParenthesesTest.class
})
public class PredicateLogicTest {

}



