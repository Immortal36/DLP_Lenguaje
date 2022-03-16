package ast;

import ast.semanthic.Visitor;

public class Real extends AbstractType {
    private static Real instance;

    public Real(int line, int column) {
        super(line, column);
    }

    public static Real getInstance() {
        if (instance == null)
            instance = new Real(0, 0);
        return instance;
    }

    public boolean isBuiltInType() {
        return true;
    }

    public Type arithmetic(Type type) {
        if (type.equals(Real.getInstance()) || type instanceof ErrorType)
            return type;
        return null;
    }

    public Type arithmetic() {
        return this;
    }

    public Type comparison(Type type) {
        if (type.equals(Real.getInstance()) || type instanceof ErrorType)
            return type;
        return null;
    }

    public Type promotesTo(Type type) {
        if (type.equals(Real.getInstance()) || type instanceof ErrorType)
            return type;
        return null;
    }

    public Type canBeCastTo(Type type) {
        if (type.equals(Integer.getInstance()) || type.equals(Real.getInstance()) || type.equals(Char.getInstance()))
            return type;
        return null;
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    @Override
    public String suffix() {
        return "f";
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
