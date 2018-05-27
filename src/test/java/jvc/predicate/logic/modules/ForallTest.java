package jvc.predicate.logic.modules;

import jvc.predicate.engine.SymbolTable;
import jvc.predicate.engine.types.PLTypeFactory;
import jvc.predicate.logic.utils.PLUtil;
import org.junit.Test;

public class ForallTest {

    @Test
    public void test1() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));

        PLUtil.test(true, symbolTable, "forall {a:A} a >= 10");

    }

    @Test
    public void test2() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));

        PLUtil.test(true, symbolTable, "forall {a:A}  a - 6 > 3  ");

    }

    @Test
    public void test3() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));
        symbolTable.addVariable("B", PLTypeFactory.add(1, 2, 3));

        PLUtil.test(true, symbolTable, "forall {a, b:A, B}  a > b  ");

    }

    @Test
    public void test4() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));
        symbolTable.addVariable("B", PLTypeFactory.add(1, 2, 3));

        PLUtil.test(true, symbolTable, "forall {a, b:A, B}  b - a < 0  and b >= 1 ");

    }

    @Test
    public void test5() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add(10, 11, 12));
        symbolTable.addVariable("B", PLTypeFactory.add(1, 2, 3));

        PLUtil.test(false, symbolTable, "forall {a, b:A, B}    a < 0 and b < 0   ");

    }

    @Test
    public void test6() {

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.addVariable("A", PLTypeFactory.add());

        PLUtil.test(true, symbolTable, "forall {a:A}    a < 0 ");

    }
}
