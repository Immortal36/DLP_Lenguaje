package ast;

import ast.semanthic.Visitor;

import java.util.List;

public class Print extends AbstractStatement {
    private List<Expression> expression;

    public Print(int line, int column, List<Expression> expression) {
        super(line, column);
        this.expression = expression;
    }

    public List<Expression> getExpression() {
        return expression;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
