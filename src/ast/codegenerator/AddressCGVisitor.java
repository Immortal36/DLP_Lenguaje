package ast.codegenerator;

import ast.*;

import ast.Integer;

public class AddressCGVisitor extends AbstractCGVisitor {

    private CodeGenerator cg;
    private ValueCGVisitor valueV;

    public AddressCGVisitor(CodeGenerator cg, ValueCGVisitor valueV) {
        this.cg = cg;
        this.valueV = valueV;
    }

    /**
     *address[[ FieldAccess : expression => expression field ]]() =
     *  address[[expression]]
     *
     * 	<push> field.offset
     * 	<add>
     */
    @Override
    public Object visit(FieldAccess obj, Object params) {
        obj.getExpression().accept(this, params);
        Struct struct = (Struct) obj.getExpression().getType();

        for(FieldDefinition fd : struct.getVariables())
            if(fd.getName().equals(obj.getField()))
                cg.push(Integer.getInstance(), fd.getOffset());

        cg.add(Integer.getInstance());
        return null;
    }

    /**
     *address[[ ArrayAccess : expression => position array ]]() =
     *  address[[array]]
     *	value[[position]]
     *
     * 	<push> obj.getType().numberOfBytes()
     * 	<mul>
     * 	<add>
     */
    @Override
    public Object visit(ArrayAccess obj, Object params) {
        obj.getArray().accept(this, params);
        obj.getPosition().accept(valueV, params);

        cg.push(Integer.getInstance(), obj.getType().numberOfBytes());
        cg.mul(Integer.getInstance());
        cg.add(Integer.getInstance());

        return null;
    }


    /**
     *address[[ Variable : expression => ident ]]() =
     *  if(expression.definition.scope == 0)
     *      <pusha> expression.definition.offset
     *
     *  else
     *      <push bp>
     *      <pushi> expression.definition.offset
     *      <addi>
     */
    @Override
    public Object visit(Variable obj, Object params) {
        VarDefinition varDef = (VarDefinition) obj.getDefinition();

        if(obj.getDefinition().getScope() == 0)
            cg.pusha(varDef.getOffset());

        else {
            cg.pushBP();
            cg.push(Integer.getInstance(), varDef.getOffset());
            cg.add(Integer.getInstance());
        }

        return null;
    }
}
