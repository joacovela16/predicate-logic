/* <java imports>  */
package jvc.predicate.grammar.def;

import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import jvc.predicate.engine.types.impl.*;
%%
/* <jflex options>  */
%class AnalizadorLexico
%line
%column
%cup
%char
%standalone
%public


%{

    public AnalizadorLexico(ComplexSymbolFactory sf){
        this(null, sf);
    }

    public AnalizadorLexico(java.io.Reader in, ComplexSymbolFactory sf){
        this(in);
        this.symbolFactory = sf;
    }

    public void setReader(java.io.Reader in){
        this.zzReader = in;
    }

    private ComplexSymbolFactory symbolFactory ;

    private Symbol symbol(String name, int sym, Object val) {
        Location left = new Location(yyline+1,yycolumn+1,yychar);
        Location right= new Location(yyline+1,yycolumn+yylength(), yychar+yylength());
        return symbolFactory.newSymbol(name, sym, left, right,val);
    }

    private void error(String message) {
        System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
    }

%}

%eofval{
    return symbol("eof", sym.EOF, null);
%eofval}

 /*< regular expessions macros >  */

_Digito = [0-9]
_NoCeroDigito = [1-9]
_Int= ({_NoCeroDigito}{_Digito}* | "0")

_Fraccion=  "."{_Digito}+
_Float= {_Int}{_Fraccion}

_Mayusculas= [A-Z]
_Minusculas=[a-z]
_Letra =  ({_Minusculas} | {_Mayusculas} )
_Relation = {_Mayusculas}({_Mayusculas})*
_Identifier = {_Minusculas}({_Minusculas}|{_Digito})*
_ComillaSimple=  \"([^\\\"]|\\.)*\"
_SetName = ({_Mayusculas}+{_Minusculas}*)+
_Espacio_en_Blanco = \s


%%
/*< lexical actions >*/

// PALABRAS RESERVADAS
<YYINITIAL> {  
                ("true" | "false") { return symbol(yytext(), sym.BOOLEAN, new PLBoolean(yytext())); }
                "forall"    { return symbol("forall", sym.FORALL, null); }
                "exists"    { return symbol("exists", sym.EXISTS, null); }
}

// OPERADORES BOOLEANOS
<YYINITIAL> {   
                "and"   { return symbol("and", sym.AND, null); }
                "or"    { return symbol("or", sym.OR, null); }
                "not"   { return symbol("not", sym.NOT, null); }
}

<YYINITIAL> {
                "\n" {}
                {_SetName} { return symbol( String.format("set(%s)", yytext()) , sym.SETNAME, yytext()); }
                { _Relation} { return symbol(yytext(), sym.RELATION, yytext()); }
                { _Identifier} { return symbol(yytext(), sym.IDENTIFIER, yytext()); }
                {_ComillaSimple} { return symbol("int", sym.STRING, new PLString(yytext())); }
                { _Int} { return symbol("int", sym.INT_NUMBER, new PLInt(Integer.valueOf(yytext()))); }
                {_Float} {return symbol("float", sym.FLOAT_NUMBER, new PLFloat(Float.valueOf(yytext())));}
                {_Espacio_en_Blanco} {}
}

// SIGNOS
<YYINITIAL> {
                "("     { return symbol("(", sym.AP_CURVO, null); }
                ")"     { return symbol(")", sym.CP_CURVO, null); }
                "{"     { return symbol("{", sym.A_LLAVES, null); }
                "}"     { return symbol("}", sym.C_LLAVES, null); }
                ":"     { return symbol(":", sym.DOS_PUNTOS, null); }
                "."     { return symbol(".", sym.PUNTO, null); }
                ","     { return symbol(",", sym.COMA, null); }
}

// OPERADORES ARITMETICOS
<YYINITIAL> {
                "+"     { return symbol("plus", sym.PLUS_OP, null); }
                "-"     { return symbol("minus", sym.MINUS_OP, null); }
                "*"     { return symbol("times", sym.TIME_OP, null); }
}


// OPERADORES RELACIONALES
<YYINITIAL> {   
                "=="    { return symbol("equals", sym.EQUAL_OP, null); }
                "!="    { return symbol("not_equals", sym.NOT_EQUAL_OP, null); }
                "<"     { return symbol("less_than", sym.LT_OP, null); }
                ">"     { return symbol("great_than", sym.GT_OP, null); }
                "<="    { return symbol("less_equal", sym.LE_OP, null); }
                ">="    { return symbol("great_equal", sym.GE_OP, null); }
}


/* errores */
<YYINITIAL>[$ | ?] { }

