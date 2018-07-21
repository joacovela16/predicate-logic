package jvc.predicate.logic.modules;

import jvc.predicate.logic.utils.PLTestUtil;
import org.junit.Test;

public class LogicalTest {

    @Test
    public void test1() {

        PLTestUtil.test(true, "  true and true  ");
    }

    @Test
    public void test2() {

        PLTestUtil.test(false, "  true and false  ");
    }

    @Test
    public void test3() {

        PLTestUtil.test(true, "  not false ");
    }

    @Test
    public void test4() {

        PLTestUtil.test(true, "  false or true  ");
    }

    @Test
    public void test5() {

        PLTestUtil.test(false, "  false or false   ");
    }

    @Test
    public void test6() {

        PLTestUtil.test(true, "  false or (not false)   ");
    }

    @Test
    public void test7() {

        PLTestUtil.test(true, "  ((not true) or (not false) ) and ( 5 + 5 == 10 )   ");
    }

    @Test
    public void test8() {

        PLTestUtil.test(true, "not (  5 * 2  < 5 )");

    }
}
