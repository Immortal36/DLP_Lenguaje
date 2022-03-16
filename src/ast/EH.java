package ast;

import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;

public class EH {
    private List<ErrorType> errors;
    private static EH instance;

    private EH() {
        this.errors = new ArrayList<ErrorType>();
    }

    public static EH getEH() {
        if(instance == null)
            instance = new EH();
        return instance;
    }

    public void showErrors(PrintStream out) {
        for(ErrorType error : errors)
            out.println(error.getError());
    }

    public void addError(ErrorType error) {
        errors.add(error);
    }

    public boolean anyErrors() {
        return !errors.isEmpty();
    }

}
