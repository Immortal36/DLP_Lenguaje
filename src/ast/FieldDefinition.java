package ast;

import ast.semanthic.Visitor;

public class FieldDefinition extends AbstractDefinition {
    private int offset;

    public FieldDefinition(int line, int column, Type type, String name) {
        super(line, column, type, name);
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}