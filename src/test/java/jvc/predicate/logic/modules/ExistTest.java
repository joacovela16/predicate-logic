package jvc.predicate.logic.modules;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.types.PLTypeFactory;
import jvc.predicate.logic.utils.PLUtil;
import org.junit.Ignore;
import org.junit.Test;

public class ExistTest {

    @Test
    public void test1() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));

        PLUtil.test(true, symbolTable, "exist {a:A} a == 12");

    }

    @Test
    public void test2() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));

        PLUtil.test(false, symbolTable, "exist {a:A}  a == 7 ");

    }

    @Test
    public void test3() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));
        symbolTable.addVariable("B", PLTypeFactory.add(1, 2, 3));

        PLUtil.test(true, symbolTable, "exist { a, b: A, B}  a > b  ");

    }

}
