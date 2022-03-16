package ast.codegenerator;

import ast.Char;
import ast.Real;
import ast.Type;
import ast.Integer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeGenerator {
    private int label = 0;
    private PrintWriter fichero;

    public CodeGenerator(String ficheroSalida, String ficheroFuente) {
        try {
            fichero = new PrintWriter(ficheroSalida);
            source(ficheroFuente);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * ETIQUETAS
     */
    public void label(String id) {
        fichero.println("\t" + id + ":");
        fichero.flush();
    }

    public int getLabel() {
        label++;
        return label;
    }

    /**
     * CONVERSIONES DE TIPOS,
     * OPERACIONES ARITMETICAS,
     * COMPARACIONES Y OPERACIONES LOGICAS
     */

    public void arithmetic(String operador, Type type) {
        switch (operador) {
            case "*":
                mul(type);
                break;
            case "/":
                div(type);
                break;
            case "+":
                add(type);
                break;
            case "-":
                sub(type);
                break;
            case "%":
                mod(type);
                break;
        }
    }

    public void convertTo(Type tipoOrigen, Type tipoDestino) {
        if (tipoOrigen.equals(tipoDestino))
            return;

        if (tipoOrigen instanceof Integer) {
            if (tipoDestino instanceof Real)
                fichero.println("\ti2f");
            else if (tipoDestino instanceof Char)
                fichero.println("\ti2b");
        }

        if (tipoOrigen instanceof Real) {
            fichero.println("\tf2i");
            if (tipoDestino instanceof Char)
                fichero.println("\ti2b");
        }

        if (tipoOrigen instanceof Char) {
            fichero.println("\tb2i");
            if (tipoDestino instanceof Real)
                fichero.println("\ti2f");
        }

        fichero.flush();
    }

    public void logic(String operador) {
        switch (operador) {
            case "&&":
                and();
                break;
            case "||":
                or();
                break;
        }
    }

    public void comparation(String operador, Type type) {
        switch (operador) {
            case "==":
                eq(type);
                break;
            case "!=":
                ne(type);
                break;
            case ">":
                gt(type);
                break;
            case "<":
                lt(type);
                break;
            case ">=":
                ge(type);
                break;
            case "<=":
                le(type);
                break;
        }
    }

    /**
     * PUSH
     */
    public void pushBP() {
        fichero.println("\tpush\t" + "bp");
        fichero.flush();
    }

    public void push(Type type, int i) {
        fichero.println("\tpush" + type.suffix() + "\t" + i);
        fichero.flush();
    }

    public void push(Type type, double d) {
        fichero.println("\tpush" + type.suffix() + "\t" + d);
        fichero.flush();
    }

    public void pusha(int direccion) {
        fichero.println("\tpusha\t" + direccion);
        fichero.flush();
    }

    /**
     * OPERACIONES CON LA PILA
     */
    public void store(Type type) {
        fichero.println("\tstore" + type.suffix());
        fichero.flush();
    }

    public void load(Type type) {
        fichero.println("\tload" + type.suffix());
        fichero.flush();
    }

    public void pop(Type type) {
        fichero.println("\tpop" + type.suffix());
        fichero.flush();
    }

    public void dup(Type type) {
        fichero.println("\tdup" + type.suffix());
        fichero.flush();
    }

    /**
     * ENTRADA Y SALIDA
     */
    public void in(Type type) {
        fichero.println("\tin" + type.suffix());
        fichero.flush();
    }

    public void out(Type type) {
        fichero.println("\tout" + type.suffix());
        fichero.flush();
    }

    /**
     * OPERACIONES ARITMETICAS
     */
    public void mul(Type type) {
        fichero.println("\tmul" + type.suffix());
        fichero.flush();
    }

    public void div(Type type) {
        fichero.println("\tdiv" + type.suffix());
        fichero.flush();
    }

    public void add(Type type) {
        fichero.println("\tadd" + type.suffix());
        fichero.flush();
    }

    public void sub(Type type) {
        fichero.println("\tsub" + type.suffix());
        fichero.flush();
    }

    public void mod(Type type) {
        fichero.println("\tmod" + type.suffix());
        fichero.flush();
    }

    /**
     * OPERADORES LOGICOS
     */
    public void not() {
        fichero.println("\tnot");
        fichero.flush();
    }

    public void and() {
        fichero.println("\tand");
        fichero.flush();
    }

    public void or() {
        fichero.println("\tor");
        fichero.flush();
    }

    /**
     * COMPARADORES
     */
    public void eq(Type type) {
        fichero.println("\teq" + type.suffix());
        fichero.flush();
    }

    public void ne(Type type) {
        fichero.println("\tne" + type.suffix());
        fichero.flush();
    }

    public void gt(Type type) {
        fichero.println("\tgt" + type.suffix());
        fichero.flush();
    }

    public void ge(Type type) {
        fichero.println("\tge" + type.suffix());
        fichero.flush();
    }

    public void lt(Type type) {
        fichero.println("\tlt" + type.suffix());
        fichero.flush();
    }

    public void le(Type type) {
        fichero.println("\tle" + type.suffix());
        fichero.flush();
    }


    /**
     * METODOS PARA FUNCIONES
     */
    public void enter(int valor) {
        fichero.println("\tenter\t" + valor);
        fichero.flush();
    }

    public void call(String id) {
        fichero.println("\tcall\t" + id);
        fichero.flush();
    }

    public void ret(int bytesReturn, int variablesBytes, int paramBytes) {
        fichero.println("\tret\t" + bytesReturn + ", " + variablesBytes + ", " + paramBytes);
        fichero.flush();
    }

    /**
     * SALTOS
     */
    public void jz(String id) {
        fichero.println("\tjz\t" + id);
        fichero.flush();
    }

    public void jnz(String id) {
        fichero.println("\tjnz\t" + id);
        fichero.flush();
    }

    public void jmp(String id) {
        fichero.println("\tjmp\t" + id);
        fichero.flush();
    }

    /**
     * COMENTARIOS
     */
    public void comment(String comentario) {
        fichero.println("'" + comentario);
        fichero.flush();
    }

    public void source(String nombreFichero) {
        fichero.println("#source \"" + nombreFichero + "\"");
        fichero.flush();
    }

    public void line(int linea) {
        fichero.println("\n#line " + linea);
        fichero.flush();
    }

    /**
     * CONVERSIONES
     */
    public void i2b() {
        fichero.println("\ti2b");
        fichero.flush();
    }

    public void i2f() {
        fichero.println("\ti2f");
        fichero.flush();
    }

    public void b2i() {
        fichero.println("\tb2i");
        fichero.flush();
    }

    public void f2i() {
        fichero.println("\tf2i");
        fichero.flush();
    }

    /**
     * FIN DE FICHERO
     */
    public void halt() {
        fichero.println("\thalt");
        fichero.flush();
    }
}
