package jvc.predicate.logic.modules;

import jvc.predicate.logic.utils.PLTestUtil;
import org.junit.Test;

public class ParenthesesTest {

    @Test
    public void test1() {
        PLTestUtil.test(27, "  (2 * 6)+3 + (4+2+1) + 5 ");
    }

}
