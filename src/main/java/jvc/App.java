package jvc;

import java_cup.runtime.ComplexSymbolFactory;
import jvc.predicate.grammar.def.AnalizadorLexico;
import jvc.predicate.grammar.def.parser;

import java.io.StringReader;

/**
 * Hello world!
 */
public class App {

    static final String SOURCE = "exists a:A { not forall b:B{b==0} and true }";

    public static void main(String[] args) {
        try {
            ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();

            AnalizadorLexico analizadorLexico = new AnalizadorLexico(new StringReader(SOURCE), symbolFactory);

            parser p = new parser(analizadorLexico, symbolFactory);

            p.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
