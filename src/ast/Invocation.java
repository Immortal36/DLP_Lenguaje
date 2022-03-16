package ast;

import ast.semanthic.Visitor;

import java.util.List;

public class Invocation extends AbstractExpression implements Statement {
    private List<Expression> expression;
    private Variable nombre;

    public Invocation(int line, int column, Variable nombre, List<Expression> expression) {
        super(line, column);
        this.nombre = nombre;
        this.expression = expression;
    }

    public Variable getNombre() {
        return nombre;
    }

    public List<Expression> getExpression() {
        return expression;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
