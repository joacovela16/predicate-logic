package jvc.predicate.logic.modules;

import jvc.predicate.logic.utils.PLUtil;
import org.junit.Test;

public class ParenthesesTest {

    @Test
    public void test1() {

        PLUtil.test(27, "  (2 * 6)+3 + (4+2+1) + 5 ");

    }

}
