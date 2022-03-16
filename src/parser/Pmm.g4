grammar Pmm;	

@header {
    import ast.*;
    import java.util.*;
    import java.lang.Integer;
}

program returns [Program ast]:
                {
                 List<Definition> definiciones = new ArrayList<Definition>();
                }
            (definicion_var { definiciones.addAll($definicion_var.ast); } | definicion_func { definiciones.add($definicion_func.ast); })* main= definicion_main
                {
                definiciones.add($main.ast);
                $ast = new Program($main.start.getLine(), $main.start.getCharPositionInLine() + 1, definiciones);
                }
       ;

definicion_var returns [List<VarDefinition> ast]:
                {
                List<String> nombres = new ArrayList<String>();
                List<VarDefinition> variables = new ArrayList<VarDefinition>();
                }
            var1= VAR { nombres.add($var1.text); } (',' var2= VAR { nombres.add($var2.text); })* ':' type ';'
                {
                for(String s : nombres)
                    variables.add(new VarDefinition($var1.getLine(), $var1.getCharPositionInLine() + 1, $type.ast, s));

                $ast = variables;
                }
    ;

definicion_func returns [FuncDefinition ast]:
                {
                List<VarDefinition> parametros = new ArrayList<VarDefinition>();
                List<VarDefinition> variables = new ArrayList<VarDefinition>();
                List<Statement> sentencias = new ArrayList<Statement>();
                FunctionType tipoFuncion = null;
                }
            'def' nombre= VAR '(' (var1= VAR ':' ty1= type_simple
                { parametros.add(new VarDefinition($var1.getLine(), $var1.getCharPositionInLine() + 1, $ty1.ast, $var1.text)); }

            (',' var2= VAR ':' ty2= type_simple
            { parametros.add(new VarDefinition($var2.getLine(), $var2.getCharPositionInLine() + 1, $ty2.ast, $var2.text)); } )* )? ')'

            ':' (ty3= type_simple { tipoFuncion = new FunctionType($nombre.getLine(), $nombre.getCharPositionInLine() + 1, $ty3.ast, parametros); })?

            '{' (definicion_var { variables.addAll($definicion_var.ast); })* (sentencia { sentencias.add($sentencia.ast); })* '}'
                {
                if(tipoFuncion != null)
                    $ast = new FuncDefinition($nombre.getLine(), $nombre.getCharPositionInLine() + 1, $nombre.text, tipoFuncion, variables, sentencias);
                else {
                    tipoFuncion = new FunctionType($nombre.getLine(), $nombre.getCharPositionInLine() + 1, ast.Void.getInstance(), parametros);
                    $ast = new FuncDefinition($nombre.getLine(), $nombre.getCharPositionInLine() + 1, $nombre.text, tipoFuncion, variables, sentencias);
                }
                }
    ;

definicion_main returns [FuncDefinition ast]:
                {
                List<VarDefinition> variables = new ArrayList<VarDefinition>();
                List<Statement> sentencias = new ArrayList<Statement>();
                List<VarDefinition> parametros = new ArrayList<VarDefinition>();
                }
            def1='def' 'main' '(' ')' ':' '{' (definicion_var { variables.addAll($definicion_var.ast); })* (sentencia { sentencias.add($sentencia.ast); })* '}' EOF
                { $ast = new FuncDefinition($def1.getLine(), $def1.getCharPositionInLine() + 1, "main", new FunctionType($def1.getLine(), $def1.getCharPositionInLine() + 1, ast.Void.getInstance(), parametros), variables, sentencias); }
    ;

type_simple returns [Type ast]:
            'int'
                { $ast = ast.Integer.getInstance(); }

            | 'double'
                { $ast = Real.getInstance(); }

            | 'char'
                { $ast = Char.getInstance(); }
    ;

type returns [Type ast]:
            'int'
                { $ast = ast.Integer.getInstance(); }

            | 'double'
                { $ast = Real.getInstance(); }

            | 'char'
                { $ast = Char.getInstance(); }

            |   {
                List<FieldDefinition> variables = new ArrayList<FieldDefinition>();
                }
              s= 'struct' '{' (definicion_var {
              for(VarDefinition v : $definicion_var.ast) {
              		        FieldDefinition f = new FieldDefinition(v.getLine(), v.getColumn(), v.getType(), v.getName());
                            variables.add(f);
              }
              } )+ '}'
                {
                $ast = new Struct($s.getLine(), $s.getCharPositionInLine() + 1, variables);
                }

            |
              a='[' INT_CONSTANT ']' type
                { $ast = new Array($a.getLine(), $a.getCharPositionInLine()+1, LexerHelper.lexemeToInt($INT_CONSTANT.text), $type.ast); }
    ;

sentencia returns [Statement ast]:
            exp1= expresion '=' exp2= expresion ';'
                { $ast = new Assignment($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1, $exp1.ast, $exp2.ast); }

            |   { List<Expression> parametros = new ArrayList<Expression>(); }
               VAR '(' (exp1= expresion { parametros.add($exp1.ast); } (',' exp2= expresion { parametros.add($exp2.ast); })*)? ')' ';'
                { $ast = new Invocation($VAR.getLine(), $VAR.getCharPositionInLine() + 1, new Variable($VAR.getLine(), $VAR.getCharPositionInLine() + 1, $VAR.text), parametros); }

            |   {
                List<Statement> sentenciasIf = new ArrayList<Statement>();
                List<Statement> sentenciasElse = new ArrayList<Statement>();
                }
               'if' expresion ':' ('{' (sen1= sentencia { sentenciasIf.add($sen1.ast); })+ '}' | sen2= sentencia { sentenciasIf.add($sen2.ast); })
               ('else' ('{' (sen3= sentencia { sentenciasElse.add($sen3.ast); })+ '}' | sen4= sentencia { sentenciasElse.add($sen4.ast); }))?
                { $ast = new IfElse($expresion.start.getLine(), $expresion.start.getCharPositionInLine() + 1, $expresion.ast, sentenciasIf, sentenciasElse); }

            |   { List<Statement> sentencias = new ArrayList<Statement>(); }
               'while'  expresion ':' ('{' (sen1= sentencia { sentencias.add($sen1.ast); })+ '}' | sen2= sentencia { sentencias.add($sen2.ast); })
                { $ast = new While($expresion.start.getLine(), $expresion.start.getCharPositionInLine() + 1, sentencias, $expresion.ast); }

            |   { List<Expression> parametros = new ArrayList<Expression>(); }
              'print' exp1= expresion { parametros.add($exp1.ast); } (',' exp2= expresion { parametros.add($exp2.ast); })* ';'
                { $ast = new Print($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1, parametros); }

            |   { List<Expression> parametros = new ArrayList<Expression>(); }
              'input' exp1= expresion { parametros.add($exp1.ast); } (',' exp2= expresion { parametros.add($exp2.ast); })* ';'
                { $ast = new Input($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1, parametros); }

            | 'return' expresion ';'
                { $ast = new Return($expresion.start.getLine(), $expresion.start.getCharPositionInLine() + 1, $expresion.ast); }
    ;

expresion returns [Expression ast] :
            INT_CONSTANT
                { $ast = new IntLiteral($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToInt($INT_CONSTANT.text)); }

            | REAL_CONSTANT
                { $ast = new RealLiteral($REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToReal($REAL_CONSTANT.text)); }

            | CHAR_CONSTANT
                { $ast = new CharLiteral($CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToChar($CHAR_CONSTANT.text)); }

            | VAR
                { $ast = new Variable($VAR.getLine(), $VAR.getCharPositionInLine() + 1, $VAR.text); }

            | exp1= expresion '[' exp2= expresion ']'
                {
                $ast = new ArrayAccess($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1, $exp1.ast, $exp2.ast);
                }

            | exp1= expresion '.' VAR
                { $ast = new FieldAccess($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1, $exp1.ast, $VAR.text); }

            | '(' type_simple ')' expresion
                {
                Type tipo = $type_simple.ast;
                $ast = new Cast($type_simple.start.getLine(), $type_simple.start.getCharPositionInLine() + 1, $expresion.ast, tipo);
                }

            | '-' expresion
                { $ast = new UnaryMinus($expresion.start.getLine(), $expresion.start.getCharPositionInLine() + 1, $expresion.ast); }

            | '!' expresion
                { $ast = new Not($expresion.start.getLine(), $expresion.start.getCharPositionInLine() + 1, $expresion.ast); }

            | exp1= expresion operador= ('*' | '/' | '%') exp2= expresion
                { $ast = new Arithmetic($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1, $exp1.ast, $exp2.ast, $operador.text); }

            | exp1= expresion operador= ('+' | '-') exp2= expresion
                { $ast = new Arithmetic($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1, $exp1.ast, $exp2.ast, $operador.text); }

            | exp1= expresion operador= ( '>' | '>=' | '<' | '<=' | '!=' | '==') exp2= expresion
                { $ast = new Comparation($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1, $exp1.ast, $exp2.ast, $operador.text); }

            | exp1= expresion operador= ('&&' | '||') exp2= expresion
                { $ast = new Logic($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1, $exp1.ast, $exp2.ast, $operador.text); }

            |  { List<Expression> parametros = new ArrayList<Expression>(); }
              VAR '(' (exp1= expresion { parametros.add($exp1.ast); } (',' exp2= expresion { parametros.add($exp2.ast); })*)? ')'
               { $ast = new Invocation($VAR.getLine(), $VAR.getCharPositionInLine() + 1, new Variable($VAR.getLine(), $VAR.getCharPositionInLine() + 1, $VAR.text), parametros); }
    ;

/********** LEXER ***********/

fragment
COMENTARIOMULTILINEA: '"""' .*? '"""'
    ;

fragment
COMENTARIOUNALINA: '#' .*? '\r'? ('\n' | EOF)
    ;

fragment
EXPONENTE: [Ee] ('-' | '+')? [0-9]+
    ;

IGNORAR: ([\r\t\n ] | COMENTARIOUNALINA | COMENTARIOMULTILINEA) -> skip
    ;

INT_CONSTANT: '0' | [1-9][0-9]*
    ;

REAL_CONSTANT: ([0-9]+ '.' [1-9]*[0-9]* | [0-9]* '.' [1-9]+[0-9]*) EXPONENTE? | [0-9]* EXPONENTE
    ;

CHAR_CONSTANT:
	'\'' (('\\' [0-9]+) | . | '\\n' | '\\t') '\''
	;

VAR: [a-zA-Z_][a-zA-Z0-9_]*
    ;