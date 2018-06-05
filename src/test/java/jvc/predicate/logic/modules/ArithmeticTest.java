package jvc.predicate.logic.modules;

import jvc.predicate.logic.utils.PLTestUtil;
import org.junit.Test;

public class ArithmeticTest {

    @Test
    public void test1() {

        PLTestUtil.test(12, "5 + 7");

    }

    @Test
    public void test2() {

        PLTestUtil.test(24, "5 + 2 + 17");

    }

    @Test
    public void test3() {

        PLTestUtil.test(24, " (5 + 2) + 17");

    }

    @Test
    public void test4() {

        PLTestUtil.test(27, " (5 + 2) + (17 + 3)");

    }

    @Test
    public void test5() {

        PLTestUtil.test(21, " ( (5 + 2) + (17 - 3) ) ");

    }

    @Test
    public void test6() {

        PLTestUtil.test(27, " ( (5 + 2) +  (17 - 3) + 6 ) ");
    }

    @Test
    public void test7() {

        PLTestUtil.test(220, "  (5 + 200 + 10) + 5  ");
    }

    @Test
    public void test8() {

        PLTestUtil.test(15, " 3 + 2* 6 ");
    }
}
