package jvc.predicate.logic.modules;

import jvc.predicate.logic.utils.PLUtil;
import org.junit.Test;

public class LogicalTest {

    @Test
    public void test1() {

        PLUtil.test(true, "  true and true  ");
    }

    @Test
    public void test2() {

        PLUtil.test(false, "  true and false  ");
    }

    @Test
    public void test3() {

        PLUtil.test(true, "  not false ");
    }

    @Test
    public void test4() {

        PLUtil.test(true, "  false or true  ");
    }

    @Test
    public void test5() {

        PLUtil.test(false, "  false or false   ");
    }

    @Test
    public void test6() {

        PLUtil.test(true, "  false or (not false)   ");
    }

    @Test
    public void test7() {

        PLUtil.test(true, "  ((not true) or (not false) ) and ( 5 + 5 == 10 )   ");
    }

    @Test
    public void test8() {

        PLUtil.test(true, "not (  5 * 2  < 5 )");

    }
}
