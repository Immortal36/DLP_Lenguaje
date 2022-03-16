package ast.codegenerator;

import ast.*;
import ast.semanthic.AbstractVisitor;

public class OffSetVisitor extends AbstractVisitor {

    private int sumaLocal = 0;
    private int sumaGlobal = 0;

    @Override
    public Object visit(FunctionType obj, Object params) {
        obj.getType().accept(this, params);

        int parametros = 4;
        for (int i = obj.getParametros().size() - 1; i >= 0; i--) {
            obj.getParametros().get(i).setOffset(parametros);
            parametros += obj.getParametros().get(i).getType().numberOfBytes();
        }

        FuncDefinition f = (FuncDefinition) params;
        f.setNumBytesParametros(parametros - 4);

        return null;
    }

    @Override
    public Object visit(VarDefinition obj, Object params) {
        obj.getType().accept(this, params);

        if(obj.getScope() == 0) {
            obj.setOffset(sumaGlobal);
            sumaGlobal += obj.getType().numberOfBytes();
        }
        else {
            sumaLocal -= obj.getType().numberOfBytes();
            obj.setOffset(sumaLocal);
        }
        return null;
    }

    @Override
    public Object visit(Struct obj, Object params) {
        int sumaOffset = 0;

        for(FieldDefinition f : obj.getVariables()) {
            f.accept(this, params);
            f.setOffset(sumaOffset);
            sumaOffset += f.getType().numberOfBytes();
        }
        return null;
    }

    @Override
    public Object visit(FuncDefinition obj, Object params) {
        obj.getType().accept(this, obj);

        for (VarDefinition va : obj.getVariables())
            va.accept(this, params);

        obj.setNumBytesLocales(sumaLocal);
        sumaLocal = 0;

        for (Statement st : obj.getSentences())
            st.accept(this, params);

        return null;
    }

}
