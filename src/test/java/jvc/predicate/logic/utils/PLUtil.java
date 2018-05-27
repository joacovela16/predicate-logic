package jvc.predicate.logic.utils;

import java_cup.runtime.ComplexSymbolFactory;
import jvc.predicate.engine.PredicateLogic;
import jvc.predicate.engine.SymbolTable;
import jvc.predicate.grammar.def.AnalizadorLexico;
import jvc.predicate.grammar.def.parser;
import org.junit.Assert;

import java.io.StringReader;

public class PLUtil {

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

        PredicateLogic run = PLUtil.run(code, predicateLogic);

        Assert.assertNotNull(run);
        Assert.assertTrue(run.isSuccesfull());
        Assert.assertEquals(expected, run.getResult());
    }

    public static void test(Object expected, SymbolTable symbolTable, String code) {

        PredicateLogic predicateLogic = new PredicateLogic();
        predicateLogic.setSymbolTable(symbolTable);

        test(expected, code, predicateLogic);
    }

}
