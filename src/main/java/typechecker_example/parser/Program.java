package typechecker_example.parser;

import java.util.List;

public class Program {
    public final List<Fdef> functions;

    public Program(final List<Fdef> functions) {
        this.functions = functions;
    }
}
