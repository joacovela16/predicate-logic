package jvc;

import java_cup.runtime.ComplexSymbolFactory;
import jvc.predicate.grammar.def.AnalizadorLexico;
import jvc.predicate.grammar.def.sym;

import java.io.StringReader;

/**
 * Hello world!
 */
public class AppLexPrinter {
    public static void main(String[] args) {
        try {
            ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();

            String src = "forall {a:A} 5 == 5";

            AnalizadorLexico analizadorLexico = new AnalizadorLexico(new StringReader(src), symbolFactory);

            while (true) {
                ComplexSymbolFactory.ComplexSymbol symbol = (ComplexSymbolFactory.ComplexSymbol) analizadorLexico.next_token();

                System.out.print(" " + symbol.getName());

                if (symbol.sym == sym.EOF) return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
