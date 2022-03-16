package ast;

import ast.semanthic.Visitor;

import java.util.List;

public class ErrorType extends AbstractType{
    private String error;

    public ErrorType(int line, int column, String error) {
        super(line, column);
        this.error = error;

        EH.getEH().addError(this);
    }

    public boolean isBuiltInType(){
        return true;
    }

    public Type arithmetic(Type type){
        return this;
    }

    public Type arithmetic(){
        return this;
    }

    public Type logic(Type type){
        return this;
    }

    public Type logic(){
        return this;
    }

    public Type promotesTo(Type type){
        return this;
    }

    public Type canBeCastTo(Type type){
        return this;
    }

    public Type comparison(Type type){
        return this;
    }

    public Type squareBrackets(Type typeOfBrackets){
        return this;
    }

    public Type dot(String string){
        return this;
    }

    public Type parenthesis(List<Expression> args){
        return this;
    }

    public String getError() {
        return error;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
