package ast;

import ast.semanthic.Visitor;

public class Not extends AbstractExpression {
    private Expression expression;

    public Not(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
