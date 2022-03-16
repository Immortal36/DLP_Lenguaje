package ast;

public interface Definition extends ASTNode {
    public Type getType();
    public void setType(Type type);

    public String getName();
    public void setName(String name);

    public void setScope(int scope);
    public int getScope();
}
