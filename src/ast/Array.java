package ast;

import ast.semanthic.Visitor;

public class Array extends AbstractType{
    private int size;
    private Type type;

    public Array(int line, int column, int size, Type type) {
        super(line, column);
        this.size = size;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Type squareBrackets(Type typeOfBrackets){
        if(typeOfBrackets.equals(Integer.getInstance()))
            return type;
        return null;
    }

    @Override
    public int numberOfBytes() {
        return getType().numberOfBytes() * getSize();
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
