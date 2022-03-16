package ast;

public abstract class AbstractExpression extends AbstractASTNode implements Expression {
    private boolean lValue;
    private Type type;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    public boolean getLValue() {
        return lValue;
    }

    public void setLValue(boolean value){
        this.lValue = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
