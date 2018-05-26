package jvc.predicate.logic.modules;

import jvc.predicate.engine.PredicateLogic;
import jvc.predicate.logic.utils.PLUtil;
import org.junit.Assert;
import org.junit.Test;

public class ArithmeticTest {

    @Test
    public void test1() {

        PredicateLogic run = PLUtil.run("5 + 7");

        Assert.assertNotNull(run);
        Assert.assertTrue(run.isSuccesfull());
        Assert.assertEquals(run.getResult(), 12);
    }

    @Test
    public void test2() {

        PredicateLogic run = PLUtil.run("5 + 2 + 17");

        Assert.assertNotNull(run);
        Assert.assertTrue(run.isSuccesfull());
        Assert.assertEquals(run.getResult(), 24);
    }
}
