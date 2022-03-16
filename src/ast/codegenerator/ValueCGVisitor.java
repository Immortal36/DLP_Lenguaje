package ast.codegenerator;

import ast.*;

public class ValueCGVisitor extends AbstractCGVisitor {

    private CodeGenerator cg;
    private AddressCGVisitor addressV;

    public ValueCGVisitor(CodeGenerator cg){
        this.cg = cg;
        this.addressV = new AddressCGVisitor(cg, this);
    }

    /**
     *value [[ ArrayAccess : expression => position array ]]() =
     *  address[[ArrayAccess]]
     *	<load> arrayAccess.getType().suffix();
     */
    @Override
    public Object visit(ArrayAccess obj, Object params) {
        obj.accept(addressV, params);
        cg.load(obj.getType());

        return null;
    }

    /**
     *value [[ Cast : expression => type expression ]]() =
     *  value[[expression]]
     */
    @Override
    public Object visit(Cast obj, Object params) {
        obj.getExpression().accept(this, params);
        cg.convertTo(obj.getExpression().getType(), obj.getType());

        return null;
    }

    /**
     *value [[ CharLiteral : expression => ]]() =
     *  <push> CharLiteral.getType().suffix() CharLiteral.getValue()
     */
    @Override
    public Object visit(CharLiteral obj, Object params) {
        cg.push(obj.getType(), obj.getValue());

        return null;
    }

    /**
     *value [[ Comparation : expression => expression1 expression2 ]]() =
     *  value[[expression1]]
     * 	value[[expression2]]
     *
     * 	if(Comparation.getOperator().equals("=="))
     * 		<eq> Comparation.getType().suffix()
     * 	if(Comparation.getOperator().equals("!="))
     * 		<ne> Comparation.getType().suffix()
     *
     * 	if(Comparation.getOperator().equals(">"))
     * 		<gt> Comparation.getType().suffix()
     * 	if(Comparation.getOperator().equals(">="))
     * 		<ge> Comparation.getType().suffix()
     *
     * 	if(Comparation.getOperator().equals("<"))
     * 		<lt> Comparation.getType().suffix()
     * 	if(Comparation.getOperator().equals("<="))
     * 		<le> Comparation.getType().suffix()
     */
    @Override
    public Object visit(Comparation obj, Object params) {
        obj.getLeft().accept(this, params);
        obj.getRight().accept(this, params);

        cg.comparation(obj.getOperator(), obj.getType());

        return null;
    }

    /**
     *value [[ FieldAccess : expression => expression ]]() =
     *  address[[FieldAccess]]
     *  <load> fieldAccess.getType().suffix()
     */
    @Override
    public Object visit(FieldAccess obj, Object params) {
        obj.accept(addressV, params);
        cg.load(obj.getType());

        return null;
    }

    /**
     *value [[ IntLiteral : expression => ]]() =
     *  <push> IntLiteral.getType().getsuffix() IntLiteral.getValue()
     */
    @Override
    public Object visit(IntLiteral obj, Object params) {
        cg.push(obj.getType(), obj.getValue());

        return null;
    }

    /**
     *value [[ Invocation : expression => expression1 expression2* ]]() =
     *  for(Expression ex: expression2*)
     *      value[[ex]]()
     *  <call> expression1.name
     */
    @Override
    public Object visit(Invocation obj, Object params) {
        for(Expression ex : obj.getExpression())
            ex.accept(this, params);

        cg.call(obj.getNombre().getName());

        return null;
    }

    /**
     *value [[ Logic : expression => expression1 expression2 ]]() =
     *  value[[expression1]]
     * 	value[[expression2]]
     *
     * 	if(Logic.getOperator().equals("||"))
     * 		<or>
     *
     *  if(Logic.getOperator().equals("&&"))
     * 		<and>
     */
    @Override
    public Object visit(Logic obj, Object params) {
        obj.getLeft().accept(this, params);
        obj.getRight().accept(this, params);

        cg.logic(obj.getOperator());

        return null;
    }

    /**
     *value [[ RealLiteral : expression => ]]() =
     *  <push>RealLiteral.getType().suffix() RealLiteral.getValue()
     */
    @Override
    public Object visit(RealLiteral obj, Object params) {
        cg.push(obj.getType(), obj.getValue());

        return null;
    }

    /**
     *value [[ UnaryMinus : expression => expression ]]() =
     *  if(expression.getType().suffix().equals("i"))
     * 		<push>Integer.getInstance().suffix() 0
     *
     * 	else
     * 		<push>Real.getInstance().suffix() 0
     *
     *	value[[expression]]
     * 	<sub>expression.getType().suffix()
     */
    @Override
    public Object visit(UnaryMinus obj, Object params) {
        cg.push(obj.getExpression().getType(), 0);
        obj.getExpression().accept(this, params);
        cg.sub(obj.getExpression().getType());

        return null;
    }

    /**
     *value [[ Not : expression => expression ]]() =
     *  value[[expression]]
     *  <not>
     */
    @Override
    public Object visit(Not obj, Object params) {
        obj.getExpression().accept(this, params);
        cg.not();

        return null;
    }

    /**
     *value[[ Variable : expression => ident ]]() =
     *   address[[expression]]()
     * 	 <load> expression.type.suffix()
     */
    @Override
    public Object visit(Variable obj, Object params) {
        obj.accept(addressV, params);
        cg.load(obj.getType());

        return null;
    }

    /**
     *value [[ Arithmetic : expression => expression1 expression2 ]]() =
     * 	value[[expression1]]
     * 	cg.convertTo(expression1.type, expression2.type)
     *
     * 	value[[expression2]]
     * 	cg.convertTo(expression2.type, expression1.type)
     *
     * 	cg.arithmethic(expression1.operator, expression1.type)
     */
    @Override
    public Object visit(Arithmetic arithmetic, Object params) {
        arithmetic.getLeft().accept(this, params);
        cg.convertTo(arithmetic.getLeft().getType(), arithmetic.getType());

        arithmetic.getRight().accept(this, params);
        cg.convertTo(arithmetic.getRight().getType(), arithmetic.getType());

        cg.arithmetic(arithmetic.getOperator(), arithmetic.getType());
        return null;
    }
}
