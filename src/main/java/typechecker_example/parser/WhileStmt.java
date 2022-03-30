package typechecker_example.parser;

public class WhileStmt implements Stmt {
    public final Exp guard;
    public final Stmt body;

    public WhileStmt(final Exp guard,
                     final Stmt body) {
        this.guard = guard;
        this.body = body;
    }
}
