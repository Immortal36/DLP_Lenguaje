package ast.codegenerator;

import static java.lang.Math.abs;
import ast.*;
import ast.Integer;

public class ExecuteCGVisitor extends AbstractCGVisitor {

    private CodeGenerator cg;
    private ValueCGVisitor valueV;
    private AddressCGVisitor addressV;

    public ExecuteCGVisitor(CodeGenerator cg){
        this.cg = cg;
        this.valueV = new ValueCGVisitor(cg);
        this.addressV = new AddressCGVisitor(cg, valueV);
    }

    /**
     *execute [[ Program : program -> definition* ]]() =
     *  <call main>
     * 	<halt>
     *
     * 	for(Definition def : definition*)
     * 	    execute[[def]]()
     */
    @Override
    public Object visit(Program obj, Object params) {
        for(Definition def : obj.getDefinitions())
            if(def instanceof  VarDefinition) {
                def.accept(this, params);
            }

        cg.comment("Invocacion a la funcion main");
        cg.call("main");
        cg.halt();

        for(Definition def : obj.getDefinitions())
            if(def instanceof  FuncDefinition)
                def.accept(this, params);

        return null;
    }

    /**
     *execute [[ Input : statement -> expression* ]]() =
     * 	address[[expression]]()
     *
     *  for(Expression ex : expression*)
     *      address[[ex]]
     * 	    <in> ex.type.suffix()
     * 	    <store> ex.type.suffix()
     */
    @Override
    public Object visit(Input obj, Object params) {
        cg.line(obj.getLine());
        cg.comment("Input");

        for(Expression ex : obj.getExpression()) {
            ex.accept(addressV, params);
            cg.in(ex.getType());
            cg.store(ex.getType());
        }

        return null;
    }

    /**
     *execute [[ Print : statement -> expression* ]]() =
     *  for(Expression ex : expression*)
     * 	    value[[ex]]()
     * 	    <out> ex.type.suffix()
     */
    @Override
    public Object visit(Print obj, Object params) {
        cg.line(obj.getLine());
        cg.comment("Print");

        for(Expression ex : obj.getExpression()) {
            ex.accept(valueV, params);
            cg.out(ex.getType());
        }

        return null;
    }

    /**
     *execute [[ While : statement => expression statement* ]]() =
     * 	int n_label = cg.getLabel();
     *
     *  String label_condition = "while_Start" + n_label;
     *  String label_end = "while_End" + n_label;
     *
     * 	<label> label_condition
     * 	value[[expression]]()
     * 	<jz> label_end
     *
     * 	for(Statement statement : statement*)
     * 		execute[[statement]]()
     * 	<jmp> label_condition
     * 	<label> label_end <:>
     *
     */
    @Override
    public Object visit(While obj, Object params) {
        cg.line(obj.getLine());
        cg.comment("While");

        int n_label = cg.getLabel();

        String label_condition = "while_Start" + n_label;
        String label_end = "while_End" + n_label;

        cg.label(label_condition);
        obj.getExpression().accept(valueV, params);
        cg.jz(label_end);

        for(Statement stm : obj.getStatements())
            stm.accept(this, params);

        cg.jmp(label_condition);
        cg.label(label_end);

        return null;
    }

    /**
     *execute [[ Invocation : statement -> expression1 expression2* ]]() =
     * 	value[[Invocation]]()
     * 	if(!( (Expression)statement).type instanceof Void)
     * 		<pop> ((Expression)statement).type.suffix
     */
    @Override
    public Object visit(Invocation obj, Object params) {
        cg.line(obj.getLine());
        cg.comment("Invocacion");

        obj.accept(valueV, params);

        if(obj.getType() instanceof ast.Void == false)
            cg.pop(obj.getType());

        return null;
    }

    /**
     *execute [[ FieldDefinition : definition => type ]]() =
     * 	<enter> type.numberOfBytes()
     */
    @Override
    public Object visit(FieldDefinition obj, Object params) {
        cg.enter(obj.getType().numberOfBytes());

        return null;
    }

    /**
     *execute [[ Return : statement => expression ]](functionDefinition) =
     *  value[[expression]]()
     *
     *  <ret> functionDefinition.type.returnType.numberOfBytes() <,>
     *        functionDefinition.bytesLocalsSum <,>
     *        functionDefinition.type.bytesParamsSum
     */
    @Override
    public Object visit(Return obj, Object params) {
        cg.line(obj.getLine());
        cg.comment("Return");

        obj.getExpression().accept(valueV, params);

        FuncDefinition func = (FuncDefinition) params;
        cg.ret(obj.getExpression().getType().numberOfBytes(), abs(func.getNumBytesLocales()), func.getNumBytesParametros());

        return null;
    }

    /**
     *execute [[ Assignment : statement => expression1 expression2 ]]() =
     * 	address[[expression1]]
     * 	value[[expression2]]
     *
     * 	<store> expression1.getType().getsuffix()
     */
    @Override
    public Object visit(Assignment obj, Object params) {
        cg.line(obj.getLine());
        cg.comment("Asignacion");

        obj.getLeft().accept(addressV, params);
        obj.getRight().accept(valueV, params);

        cg.store(obj.getLeft().getType());

        return null;
    }

    /**
     *execute [[ FuncDefinition : definition => statement* varDefinition* ]]() =
     * 	<label> funcDefinition.getName()
     *
     * 	for(VarDefinition vd : varDefinition*)
     * 		<enter> vd.getType().numberOfBytes()
     *
     * 	execute[[statement*]]
     *
     * 	if(funcType.getType() instanceof Void)
     * 		<ret> 0, funcDef.getTotalBytesLocales(), funcDef.getTotalBytesParams()
     */
    @Override
    public Object visit(FuncDefinition obj, Object params) {
        cg.line(obj.getLine());
        cg.label("\n" + obj.getName());

        for(VarDefinition var : obj.getVariables())
            var.accept(this, params);

        cg.enter(abs(obj.getNumBytesLocales()));

        for(Statement st : obj.getSentences())
            st.accept(this, obj);

        FunctionType funcType = (FunctionType)obj.getType();
        if(funcType.getType().equals(ast.Void.getInstance()))
            cg.ret(0, abs(obj.getNumBytesLocales()), obj.getNumBytesParametros());

        return null;
    }

    /**
     *execute [[ IfElse : statement => expression statement1* statement2* ]]() =
     *  int n_label = cg.getLabel();
     *
     *  String else_label = "else" + n_label
     *  String if_End = "if_End" + n_label
     *
     *  value[[expression]]
     *  <jz> else_label
     *
     * 	for(Statement s : statement1*)
     * 		execute[[s]]
     * 	<jmp> if_End
     *
     * 	<label> else_label
     * 	for(Statement stm : statement2*)
     *		execute[[stm]]
     *
     * 	<label> if_End
     */
    @Override
    public Object visit(IfElse obj, Object params) {
        cg.line(obj.getLine());
        cg.comment("IfElse");

        int n_label = cg.getLabel();

        String else_label = "else" + n_label;
        String ifEnd_label = "if_End" + n_label;

        obj.getExpression().accept(valueV, params);
        cg.jz(else_label);

        for(Statement st : obj.getStatementsIf()){
            st.accept(this, params);
        }

        cg.jmp(ifEnd_label);

        cg.label(else_label);

        for(Statement st : obj.getStatementsElse()){
            st.accept(this, params);
        }

        cg.label(ifEnd_label);
        return null;
    }

    /**
     * No hay que hacer nada
     */
    @Override
    public Object visit(VarDefinition obj, Object params) {
        if(obj.getType().equals(Integer.getInstance()))
            cg.comment("int " + obj.getName() + "[offset: " + obj.getOffset() + "]");

        if(obj.getType().equals(Real.getInstance()))
            cg.comment("real " + obj.getName() + "[offset: " + obj.getOffset() + "]");

        if(obj.getType().equals(Char.getInstance()))
            cg.comment("char " + obj.getName() + "[offset: " + obj.getOffset() + "]");

        if(obj.getType() instanceof Array)
            cg.comment("array " + obj.getName() + "[offset: " + obj.getOffset() + "]");

        return null;
    }
}
