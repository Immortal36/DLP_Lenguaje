package ast;

import ast.semanthic.Visitor;

import java.util.List;

public class FuncDefinition extends AbstractDefinition {
    private List<Statement> sentences;
    private List<VarDefinition> variables;
    private int numBytesLocales;
    private int numBytesParametros;

    public FuncDefinition(int line, int column, String name, Type type, List<VarDefinition> variables, List<Statement> sentences) {
        super(line, column,type,name);
        this.variables = variables;
        this.sentences = sentences;
    }

    public List<Statement> getSentences() {
        return sentences;
    }

    public List<VarDefinition> getVariables() {
        return variables;
    }

    public void setNumBytesLocales(int numBytesLocales) {
        this.numBytesLocales = numBytesLocales;
    }

    public void setNumBytesParametros(int numBytesParametros) {
        this.numBytesParametros = numBytesParametros;
    }

    public int getNumBytesLocales() {
        return numBytesLocales;
    }

    public int getNumBytesParametros() {
        return numBytesParametros;
    }

    @Override
    public Object accept(Visitor v, Object params) {
        return v.visit(this, params);
    }
}
