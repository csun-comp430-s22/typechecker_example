package typechecker_example.parser;

public class IfStmt implements Stmt {
    final Exp guard;
    final Stmt trueBranch;
    final Stmt falseBranch;

    public IfStmt(final Exp guard,
                  final Stmt trueBranch,
                  final Stmt falseBranch) {
        this.guard = guard;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }
}
