package jvc.predicate.logic.utils;

import java_cup.runtime.ComplexSymbolFactory;
import jvc.predicate.engine.PredicateLogic;
import jvc.predicate.grammar.def.AnalizadorLexico;
import jvc.predicate.grammar.def.parser;

import java.io.StringReader;

public class PLUtil {

    public static PredicateLogic run(String code) {

        ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();

        AnalizadorLexico analizadorLexico = new AnalizadorLexico(new StringReader(code), symbolFactory);

        parser p = new parser(analizadorLexico, symbolFactory, new PredicateLogic());

        try {
            p.parse();
            return p.getPredicateLogic();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
