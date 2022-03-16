package ast.semanthic;

import ast.*;

public class IdentificationVisitor extends AbstractVisitor {
    SymbolTable sTable;

    public IdentificationVisitor() {
        this.sTable = new SymbolTable();
    }

    @Override
    public Object visit(VarDefinition obj, Object params) {
        if (!sTable.insert(obj))
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[IDENTIFICATION ERROR] Ya existe una variable con el nombre: " + obj.getName() + ". En la linea: " + obj.getLine()));

        obj.getType().accept(this, params);
        return null;
    }

    @Override
    public Object visit(Variable obj, Object params) {
        Definition def = sTable.find(obj.getName());

        if (def == null)
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[IDENTIFICATION ERROR] La variale con el nombre: " + obj.getName() + " no esta definida. Linea: " + obj.getLine()));
        else
            obj.setDefinition(def);

        return null;
    }

    @Override
    public Object visit(FuncDefinition obj, Object params) {
        if (!sTable.insert(obj))
            obj.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[IDENTIFICATION ERROR] Ya existe una funcion con el nombre: " + obj.getName() + ". Linea: " + obj.getLine()));

        sTable.set();

        obj.getType().accept(this, params);

        for (VarDefinition var : obj.getVariables())
            var.accept(this, params);

        for (Statement s : obj.getSentences())
            s.accept(this, params);

        sTable.reset();

        return null;
    }

    @Override
    public Object visit(Struct obj, Object params) {

        sTable.set();

        for (FieldDefinition f : obj.getVariables()) {
            if (!sTable.insert(f))
                f.setType(new ErrorType(obj.getLine(), obj.getColumn(), "[ERROR IDENTIFICATION] Ya existe un atributo del struct con el nombre: " + f.getName() + ". Linea: " + f.getLine()));

            f.accept(this, params);
        }

        sTable.reset();

        return null;
    }
}
