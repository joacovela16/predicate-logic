package jvc;

import java_cup.runtime.ComplexSymbolFactory;
import jvc.predicate.grammar.def.AnalizadorLexico;
import jvc.predicate.grammar.def.parser;

import java.io.StringReader;

/**
 * Hello world!
 */
public class App {

    public static final String SOURCE = "(not true and (true or (not false)))";//"true and not(  1 == 0 )";

    public static void main(String[] args) {
        try {
            ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();

            String src = SOURCE;

            AnalizadorLexico analizadorLexico = new AnalizadorLexico(new StringReader(src), symbolFactory);

            parser p = new parser(analizadorLexico, symbolFactory);

            p.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
