package ast;

import ast.semanthic.Visitor;

public class Integer extends AbstractType{
    private static Integer instance;

    private Integer(int line, int column) {
        super(line, column);
    }

    public static Integer getInstance() {
        if(instance == null)
            instance = new Integer(0, 0);
        return instance;
    }

    public Type comparison(Type type){
        if(type.equals(Integer.getInstance()) || type instanceof ErrorType)
            return type;
        return null;
    }

    public Type logic(Type type){
        if(type.equals(Integer.getInstance()) || type instanceof ErrorType)
            return type;
        return null;
    }

    public Type logic(){
        return this;
    }

    public Type promotesTo(Type type){
        if(type.equals(Integer.getInstance()) || type instanceof ErrorType)
            return type;
        return null;
    }

    public Type arithmetic(Type type){
        if(type.equals(Integer.getInstance()) || type instanceof ErrorType)
            return type;
        return null;
    }

    public Type arithmetic(){
        return this;
    }

    public boolean isBuiltInType(){
        return true;
    }

    @Override
    public int numberOfBytes(){
        return 2;
    }

    public boolean isLogical(){
        return true;
    }

    @Override
    public String suffix() {
        return "i";
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
