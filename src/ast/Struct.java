package ast;

import ast.semanthic.Visitor;

import java.util.List;

public class Struct extends AbstractType {
    private List<FieldDefinition> variables;

    public Struct(int line, int column, List<FieldDefinition> variables) {
        super(line, column);
        this.variables = variables;
    }

    public List<FieldDefinition> getVariables() {
        return variables;
    }

    public Type dot(String string) {
        for(FieldDefinition f : variables)
            if(f.getName().equals(string))
                return f.getType();

        return null;
    }

    @Override
    public int numberOfBytes(){
        int bytes = 0;

        for(FieldDefinition f : getVariables())
            bytes += f.getType().numberOfBytes();
        return bytes;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
