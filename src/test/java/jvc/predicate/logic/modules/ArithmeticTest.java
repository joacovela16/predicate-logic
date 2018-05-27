package jvc.predicate.logic.modules;

import jvc.predicate.logic.utils.PLUtil;
import org.junit.Test;

public class ArithmeticTest {

    @Test
    public void test1() {

        PLUtil.test(12, "5 + 7");

    }

    @Test
    public void test2() {

        PLUtil.test(24, "5 + 2 + 17");

    }

    @Test
    public void test3() {

        PLUtil.test(24, " (5 + 2) + 17");

    }

    @Test
    public void test4() {

        PLUtil.test(27, " (5 + 2) + (17 + 3)");

    }

    @Test
    public void test5() {

        PLUtil.test(21, " ( (5 + 2) + (17 - 3) ) ");

    }

    @Test
    public void test6() {

        PLUtil.test(27, " ( (5 + 2) +  (17 - 3) + 6 ) ");
    }

    @Test
    public void test7() {

        PLUtil.test(220, "  (5 + 200 + 10) + 5  ");
    }

    @Test
    public void test8() {

        PLUtil.test(15, " 3 + 2* 6 ");
    }
}
