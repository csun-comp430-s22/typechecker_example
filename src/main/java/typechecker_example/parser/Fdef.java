package typechecker_example.parser;

import java.util.List;

public class Fdef {
    public final Type returnType;
    public final FunctionName fname;
    public final List<Vardec> arguments;
    public final Stmt body;

    public Fdef(final Type returnType,
                final FunctionName fname,
                final List<Vardec> arguments,
                final Stmt body) {
        this.returnType = returnType;
        this.fname = fname;
        this.arguments = arguments;
        this.body = body;
    }
}
