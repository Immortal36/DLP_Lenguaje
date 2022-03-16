package ast.semanthic;

import ast.*;
import ast.Integer;

public class TypeCheckingVisitor extends AbstractVisitor {

    @Override
    public Object visit(ArrayAccess obj, Object params) {
        obj.setLValue(true);
        obj.getArray().accept(this, params);
        obj.getPosition().accept(this, params);

        if(!obj.getArray().getLValue())
            EH.getEH().addError(new ErrorType(obj.getArray().getLine(), obj.getArray().getColumn(), "[LVALUE ERROR] " + obj.toString() + " no es un LValue. Linea: " + obj.getLine()));

        obj.setType(obj.getArray().getType().squareBrackets(obj.getPosition().getType()));
        if(obj.getType() == null)
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] Tipo o indice incorrecto. Linea: " + obj.getLine()));

        return null;
    }

    @Override
    public Object visit(Arithmetic obj, Object params) {
        obj.setLValue(false);
        obj.getLeft().accept(this, params);
        obj.getRight().accept(this, params);

        obj.setType(obj.getLeft().getType().arithmetic(obj.getRight().getType()));
        if(obj.getType() == null)
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] No se puede realizar la operacion con estos tipos. Linea: " + obj.getLine()));

        return null;
    }

    @Override
    public Object visit(Assignment obj, Object params) {
        obj.getLeft().accept(this, params);
        obj.getRight().accept(this, params);

        if(!obj.getLeft().getLValue())
            obj.getLeft().setType(new ErrorType(obj.getLine(), obj.getColumn(), "[LVALUE ERROR] " + obj.getLeft().toString() + " no es un LValue. Linea: " + obj.getLine()));

        if(obj.getLeft().getType().promotesTo(obj.getRight().getType()) == null) {
            obj.getLeft().setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] Los tipos no coinciden o no son válidos. Linea: " + obj.getLine()));
        }

        return null;
    }

    @Override
    public Object visit(Cast obj, Object params) {
        obj.setLValue(false);
        obj.getExpression().accept(this, params);

        obj.setType(obj.getExpression().getType().canBeCastTo(obj.getType()));
        if(obj.getType() == null)
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] La expresión no puede ser casteada. Linea: " + obj.getLine()));

        return null;
    }

    @Override
    public Object visit(CharLiteral obj, Object params) {
        obj.setLValue(false);
        obj.setType(Char.getInstance());

        return null;
    }

    @Override
    public Object visit(Comparation obj, Object params) {
        obj.setLValue(false);
        obj.getLeft().accept(this, params);
        obj.getRight().accept(this, params);

        obj.setType(obj.getLeft().getType().comparison(obj.getRight().getType()));
        if(obj.getType() == null)
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] Las expresiones no se pueden comparar. Linea: " + obj.getLine()));

        return null;
    }

    @Override
    public Object visit(FieldAccess obj, Object params) {
        obj.setLValue(true);
        obj.getExpression().accept(this, params);

        obj.setType(obj.getExpression().getType().dot(obj.getField()));
        if(obj.getType() == null)
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] No existe el campo indicado. Linea: " + obj.getLine()));

        return null;
    }

    @Override
    public Object visit(Invocation obj, Object params) {
        obj.setLValue(false);
        obj.getNombre().accept(this, params);

        for(Expression e : obj.getExpression())
            e.accept(this, params);

        obj.setType(obj.getNombre().getType().parenthesis(obj.getExpression()));
        if(obj.getType() == null)
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] Los parametros de la funcion no coinciden con su definicion. Linea: " + obj.getLine()));

        return null;
    }

    @Override
    public Object visit(IfElse obj, Object params) {
        obj.getExpression().accept(this, params);

        if(!obj.getExpression().getType().isLogical())
            obj.getExpression().setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] La condicion de if no es logica. Linea: " + obj.getLine()));

        for(Statement s : obj.getStatementsIf())
            s.accept(this, params);

        for(Statement s : obj.getStatementsElse())
            s.accept(this, params);

        return null;
    }

    @Override
    public Object visit(Input obj, Object params) {
        for(Expression ex : obj.getExpression()) {
            ex.accept(this, params);

            if(!ex.getLValue())
                ex.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[LVALUE ERROR] No se puede asignar un valor a esta expresion. Linea: " + ex.getLine()));

            if(!ex.getType().isBuiltInType())
                ex.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] Es un tipo no primitivo. Linea: " + ex.getLine()));
        }

        return null;
    }

    @Override
    public Object visit(IntLiteral obj, Object params) {
        obj.setLValue(false);
        obj.setType(Integer.getInstance());
        return null;
    }

    @Override
    public Object visit(Logic obj, Object params) {
        obj.setLValue(false);
        obj.getLeft().accept(this, params);
        obj.getRight().accept(this, params);

        obj.setType(obj.getLeft().getType().logic(obj.getRight().getType()));
        if(obj.getType() == null)
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] Tipos no validos en una operacion logica. Linea: " + obj.getLine()));

        return null;
    }

    @Override
    public Object visit(Not obj, Object params) {
        obj.setLValue(false);
        obj.getExpression().accept(this, params);

        obj.setType(obj.getExpression().getType().logic());
        if(obj.getType() == null)
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] La expresion no puede negarse. Linea: " + obj.getLine()));

        return null;
    }

    @Override
    public Object visit(Print obj, Object params) {
        for(Expression ex : obj.getExpression()) {
            ex.accept(this, params);

            if(!ex.getType().isBuiltInType())
                ex.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] Es un tipo no primitivo. Linea: " + ex.getLine()));
        }

        return null;
    }

    @Override
    public Object visit(UnaryMinus obj, Object params) {
        obj.setLValue(false);
        obj.getExpression().accept(this, params);

        obj.setType(obj.getExpression().getType().arithmetic());
        if(obj.getType() == null)
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] La expresion no puede ser negativa. Linea: " + obj.getLine()));

        return null;
    }

    @Override
    public Object visit(While obj, Object params) {
        obj.getExpression().accept(this, params);

        if(!obj.getExpression().getType().isLogical())
            obj.getExpression().setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] La condicion no es logica. Linea: " + obj.getLine()));

        for(Statement s : obj.getStatements())
            s.accept(this, params);

        return null;
    }

    @Override
    public Object visit(Variable obj, Object params) {
        obj.setLValue(true);
        obj.setType(obj.getDefinition().getType());
        return null;
    }

    @Override
    public Object visit(VarDefinition obj, Object params) {
        obj.getType().accept(this, params);
        return null;
    }

    @Override
    public Object visit(Return obj, Object params) {
        obj.getExpression().accept(this, params);

        FunctionType funcType = (FunctionType) params;

        if(obj.getExpression().getType().promotesTo(funcType.getType()) == null)
            obj.getExpression().setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] El tipo de retorno no coincide con el tipo de la funcion. Linea: " + obj.getLine()));

        if(!obj.getExpression().getType().isBuiltInType())
            obj.getExpression().setType(new ErrorType(obj.getLine(), obj.getColumn(), "[TYPECHECKING ERROR] El tipo de retorno debe ser un tipo simple. Linea: " + obj.getLine()));

        return null;
    }

    @Override
    public Object visit(RealLiteral obj, Object params) {
        obj.setLValue(false);
        obj.setType(Real.getInstance());
        return null;
    }
}
