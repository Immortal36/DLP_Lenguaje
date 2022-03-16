package ast;

import ast.semanthic.Visitor;

public class ArrayAccess extends AbstractExpression{
    private Expression array;
    private Expression position;

    public ArrayAccess(int line, int column, Expression array, Expression position) {
        super(line, column);
        this.array = array;
        this.position = position;
    }

    public Expression getArray() {
        return array;
    }

    public Expression getPosition() {
        return position;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
