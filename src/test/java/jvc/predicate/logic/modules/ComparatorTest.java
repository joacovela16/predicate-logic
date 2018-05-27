package jvc.predicate.logic.modules;

import jvc.predicate.logic.utils.PLUtil;
import org.junit.Test;

public class ComparatorTest {

    @Test
    public void test1() {

        PLUtil.test(true, "5 < 7");

    }

    @Test
    public void test2() {

        PLUtil.test(true, "5 <= 7");

    }

    @Test
    public void test3() {

        PLUtil.test(true, "5 != 7");

    }

    @Test
    public void test4() {

        PLUtil.test(false, "5 > 7");

    }

    @Test
    public void test5() {

        PLUtil.test(false, "5 >= 7");

    }

    @Test
    public void test6() {

        PLUtil.test(true, "15 > 7");

    }

    @Test
    public void test7() {

        PLUtil.test(true, "15 >= 7");

    }

    @Test
    public void test8() {

        PLUtil.test(false, "15 == 7");

    }

}
