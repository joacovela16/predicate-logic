package jvc.predicate.logic.modules;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.type.PLTypeFactory;
import jvc.predicate.logic.utils.PLTestUtil;
import org.junit.Test;

public class ExistTest {

    @Test
    public void test1() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));

        PLTestUtil.test(true, symbolTable, "exist {a:A} a == 12");

    }

    @Test
    public void test2() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));

        PLTestUtil.test(false, symbolTable, "exist {a:A}  a == 7 ");
    }

    @Test
    public void test3() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));
        symbolTable.addVariable("B", PLTypeFactory.add(1, 2, 3));

        PLTestUtil.test(true, symbolTable, "exist { a, b: A, B}  a > b  ");

    }

}
