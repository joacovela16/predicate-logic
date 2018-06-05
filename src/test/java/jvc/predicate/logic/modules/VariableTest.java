package jvc.predicate.logic.modules;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.type.PLTypeFactory;
import jvc.predicate.logic.utils.PLTestUtil;
import org.junit.Test;

public class VariableTest {

    @Test
    public void test1() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("n", 5);

        PLTestUtil.test(true, symbolTable, "n == 5");

    }

    @Test
    public void test2() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("n", 5);
        symbolTable.addVariable("p", 7);

        PLTestUtil.test(true, symbolTable, "n + 2 == p ");

    }

    @Test
    public void test3() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("n", 5);
        symbolTable.addVariable("p", 7);
        symbolTable.addVariable("m", 8);

        PLTestUtil.test(true, symbolTable, "n + 10 == p + m ");

    }
}
