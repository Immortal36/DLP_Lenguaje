package ast.semanthic;

import java.util.*;

import ast.Definition;

public class SymbolTable {
    private int scope = 0;
    private List<Map<String, Definition>> tabla;

    public SymbolTable() {
        tabla = new ArrayList<Map<String, Definition>>();
        tabla.add(new HashMap<String, Definition>());
    }

    public void set() {
        tabla.add(new HashMap<String, Definition>());
        scope++;
    }

    public void reset() {
        tabla.remove(tabla.size() - 1);
        scope--;
    }

    public boolean insert(Definition definition) {
        if (findInCurrentScope(definition.getName()) != null)
            return false;

        tabla.get(tabla.size() - 1).put(definition.getName(), definition);
        definition.setScope(scope);

        return true;
    }

    public Definition find(String id) {
        for (int i = tabla.size() - 1; i >= 0; i--) {
            Definition def = tabla.get(i).get(id);
            if (def != null)
                return def;
        }
        return null;
    }

    public Definition findInCurrentScope(String id) {
        return tabla.get(tabla.size() - 1).get(id);
    }
}
