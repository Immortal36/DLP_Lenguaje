// Generated from C:/Users/ignac/Desktop/Uni/20-21/DLP/PL/DLP-Lenguaje/src/parser\Pmm.g4 by ANTLR 4.9.1
package parser;

    import ast.*;
    import java.util.*;
    import java.lang.Integer;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PmmParser}.
 */
public interface PmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#definicion_var}.
	 * @param ctx the parse tree
	 */
	void enterDefinicion_var(PmmParser.Definicion_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#definicion_var}.
	 * @param ctx the parse tree
	 */
	void exitDefinicion_var(PmmParser.Definicion_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#definicion_func}.
	 * @param ctx the parse tree
	 */
	void enterDefinicion_func(PmmParser.Definicion_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#definicion_func}.
	 * @param ctx the parse tree
	 */
	void exitDefinicion_func(PmmParser.Definicion_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#definicion_main}.
	 * @param ctx the parse tree
	 */
	void enterDefinicion_main(PmmParser.Definicion_mainContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#definicion_main}.
	 * @param ctx the parse tree
	 */
	void exitDefinicion_main(PmmParser.Definicion_mainContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type_simple}.
	 * @param ctx the parse tree
	 */
	void enterType_simple(PmmParser.Type_simpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type_simple}.
	 * @param ctx the parse tree
	 */
	void exitType_simple(PmmParser.Type_simpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(PmmParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(PmmParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(PmmParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(PmmParser.ExpresionContext ctx);
}