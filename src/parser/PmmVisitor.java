// Generated from C:/Users/ignac/Desktop/Uni/20-21/DLP/PL/DLP-Lenguaje/src/parser\Pmm.g4 by ANTLR 4.9.1
package parser;

    import ast.*;
    import java.util.*;
    import java.lang.Integer;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#definicion_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicion_var(PmmParser.Definicion_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#definicion_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicion_func(PmmParser.Definicion_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#definicion_main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicion_main(PmmParser.Definicion_mainContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#type_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_simple(PmmParser.Type_simpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PmmParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia(PmmParser.SentenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(PmmParser.ExpresionContext ctx);
}