package ast;

import ast.semanthic.Visitor;

import java.util.List;

public class FunctionType extends AbstractType{
    private Type retorno;
    private List<VarDefinition> parametros;

    public FunctionType(int line, int column, Type retorno, List<VarDefinition> parametros) {
        super(line, column);
        this.retorno = retorno;
        this.parametros = parametros;
    }

    public List<VarDefinition> getParametros() {
        return parametros;
    }

    public Type getType() {
        return retorno;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }

    public Type parenthesis(List<Expression> args) {
        if(args.size() != parametros.size())
            return null;

        for(int i = 0; i < args.size(); i++)
            if(args.get(i).getType().promotesTo(parametros.get(i).getType()) == null)
                return null;

        return retorno;
    }
}
