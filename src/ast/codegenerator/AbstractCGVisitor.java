package ast.codegenerator;

import ast.*;
import ast.Integer;
import ast.Void;
import ast.semanthic.Visitor;

public class AbstractCGVisitor implements Visitor {

    @Override
    public Object visit(Array obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(ArrayAccess obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Arithmetic obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Assignment obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Cast obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Char obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(CharLiteral obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Comparation obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(ErrorType obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(FieldAccess obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Invocation obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(FieldDefinition obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(FuncDefinition obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(FunctionType obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(IfElse obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Input obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Integer obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(IntLiteral obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Logic obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Not obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Print obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Program obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(UnaryMinus obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Struct obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(While obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(VarDefinition obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Variable obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Void obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Return obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(Real obj, Object params) {
        return new IllegalStateException();
    }

    @Override
    public Object visit(RealLiteral obj, Object params) {
        return new IllegalStateException();
    }
}
