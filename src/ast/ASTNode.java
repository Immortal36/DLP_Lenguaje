package ast;

import ast.semanthic.Visitor;

public interface ASTNode {
    public int getLine();
    public int getColumn();
    public Object accept(Visitor v, Object params);
}
