package jvc.predicate.logic.modules;

import jvc.predicate.logic.utils.PLTestUtil;
import org.junit.Test;

public class ComparatorTest {

    @Test
    public void test1() {

        PLTestUtil.test(true, "5 < 7");

    }

    @Test
    public void test2() {

        PLTestUtil.test(true, "5 <= 7");

    }

    @Test
    public void test3() {

        PLTestUtil.test(true, "5 != 7");

    }

    @Test
    public void test4() {

        PLTestUtil.test(false, "5 > 7");

    }

    @Test
    public void test5() {

        PLTestUtil.test(false, "5 >= 7");

    }

    @Test
    public void test6() {

        PLTestUtil.test(true, "15 > 7");

    }

    @Test
    public void test7() {

        PLTestUtil.test(true, "15 >= 7");

    }

    @Test
    public void test8() {

        PLTestUtil.test(false, "15 == 7");

    }

}
