package jvc.predicate.logic.modules;

import jvc.predicate.logic.utils.PLTestUtil;
import org.junit.Test;

public class ConditionalTest {

    @Test
    public void test1() {

        PLTestUtil.test(true, "5 < 7 -> 4-2==2");

        PLTestUtil.test(false, "5 < 7 -> 4-2==0");

        PLTestUtil.test(true, "5 > 7 -> 4-2==2");

        PLTestUtil.test(true, "5 > 7 -> 4-2==0");

    }

    @Test
    public void test2() {

        PLTestUtil.test(true, "5 != 7 <-> 4-2==2");

        PLTestUtil.test(false, "5 < 7 <-> 4-2==0");

        PLTestUtil.test(true, "5 > 7 <-> 4-2==0");

    }
}
