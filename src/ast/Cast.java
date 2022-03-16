package ast;

import ast.semanthic.Visitor;

public class Cast extends AbstractExpression {
    private Expression expression;
    private Type type;


    public Cast(int line, int column, Expression expression, Type type) {
        super(line, column);
        this.expression = expression;
        this.type = type;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getType() {
        return type;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }

}
