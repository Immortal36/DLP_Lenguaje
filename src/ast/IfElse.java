package ast;

import ast.semanthic.Visitor;

import java.util.List;

public class IfElse extends AbstractStatement {
    private List<Statement> statementsIf;
    private List<Statement> statementsElse;
    private Expression expression;

    public IfElse(int line, int column, Expression expression, List<Statement> statementsIf, List<Statement> statementsElse) {
        super(line, column);
        this.statementsIf = statementsIf;
        this.statementsElse = statementsElse;
        this.expression = expression;
    }

    public List<Statement> getStatementsIf() {
        return statementsIf;
    }

    public List<Statement> getStatementsElse() {
        return statementsElse;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }

}
