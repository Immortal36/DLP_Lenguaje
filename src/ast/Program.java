package ast;

import ast.semanthic.Visitor;

import java.util.List;

public class Program extends AbstractASTNode{
    private List<Definition> definitions;

    public Program(int line, int column, List<Definition> definitions) {
        super(line, column);
        this.definitions = definitions;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
