package ast;

import ast.semanthic.Visitor;

import java.util.List;

public class While extends AbstractStatement {
    private List<Statement> statements;
    private Expression expression;

    public While(int line, int column, List<Statement> statements, Expression expression) {
        super(line, column);
        this.statements = statements;
        this.expression =  expression;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
