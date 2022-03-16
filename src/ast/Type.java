package ast;

import java.util.List;

public interface Type extends ASTNode{

    boolean isBuiltInType();
    boolean isLogical();

    Type arithmetic(Type type);
    Type arithmetic();
    Type logic(Type type);
    Type logic();
    Type promotesTo(Type type);
    Type canBeCastTo(Type type);
    Type comparison(Type type);
    Type squareBrackets(Type type);
    Type dot(String string);
    Type parenthesis(List<Expression> args);

    int numberOfBytes();
    String suffix();
}
