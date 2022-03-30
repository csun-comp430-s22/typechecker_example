package typechecker_example.parser;

public class ReturnStmt implements Stmt {
    public final Exp exp;

    public ReturnStmt(final Exp exp) {
        this.exp = exp;
    }
}
