package jvc.predicate.logic.modules;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.types.PLTypeFactory;
import jvc.predicate.logic.utils.PLUtil;
import org.junit.Test;

public class VariableTest {

    @Test
    public void test1() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("n", PLTypeFactory.add(5));

        PLUtil.test(true, symbolTable, "n == 5");

    }

    @Test
    public void test2() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("n", PLTypeFactory.add(5));
        symbolTable.addVariable("p", PLTypeFactory.add(7));

        PLUtil.test(true, symbolTable, "n + 2 == p ");

    }

    @Test
    public void test3() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("n", PLTypeFactory.add(5));
        symbolTable.addVariable("p", PLTypeFactory.add(7));
        symbolTable.addVariable("m", PLTypeFactory.add(8));

        PLUtil.test(true, symbolTable, "n + 10 == p + m ");

    }
}
