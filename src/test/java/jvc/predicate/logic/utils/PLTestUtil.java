package jvc.predicate.logic.utils;

import java_cup.runtime.ComplexSymbolFactory;
import jvc.predicate.engine.PredicateLogic;
import jvc.predicate.engine.SymbolTable;
import jvc.predicate.grammar.def.AnalizadorLexico;
import jvc.predicate.grammar.def.parser;
import org.junit.Assert;

import java.io.StringReader;

public class PLTestUtil {

    public static PredicateLogic run(String code, PredicateLogic predicateLogic) {

        ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();

        AnalizadorLexico analizadorLexico = new AnalizadorLexico(new StringReader(code), symbolFactory);

        parser p = new parser(analizadorLexico, symbolFactory, predicateLogic);

        try {
            p.parse();
            return p.getPredicateLogic();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void test(Object expected, String code) {

        test(expected, code, new PredicateLogic());
    }

    public static void test(Object expected, String code, PredicateLogic predicateLogic) {

        PredicateLogic run = PLTestUtil.run(code, predicateLogic);

        assert run != null;

        if (run.isFailure()) {
            System.out.println(run.getErrorTrace());
        }

        Assert.assertNotNull(run);
        Assert.assertTrue(run.isSuccess());
        Assert.assertEquals(expected, run.getResult());
    }

    public static void test(Object expected, SymbolTable symbolTable, String code) {

        PredicateLogic predicateLogic = new PredicateLogic();
        predicateLogic.setSymbolTable(symbolTable);

        test(expected, code, predicateLogic);
    }

    public static void test(Object expected, PredicateLogic predicateLogic, String code) {

        test(expected, predicateLogic.getSymbolTable(), code);
    }

}
