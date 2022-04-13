package typechecker_example.parser;

public class IfStmt implements Stmt {
    public final Exp guard;
    public final Stmt trueBranch;
    public final Stmt falseBranch;

    public IfStmt(final Exp guard,
                  final Stmt trueBranch,
                  final Stmt falseBranch) {
        this.guard = guard;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    public int hashCode() {
        return (guard.hashCode() +
                trueBranch.hashCode() +
                falseBranch.hashCode());
    }

    public boolean equals(final Object other) {
        if (other instanceof IfStmt) {
            final IfStmt otherIf = (IfStmt)other;
            return (guard.equals(otherIf.guard) &&
                    trueBranch.equals(otherIf.trueBranch) &&
                    falseBranch.equals(otherIf.falseBranch));
        } else {
            return false;
        }
    }

    public String toString() {
        return ("IfStmt(" + guard.toString() + ", " +
                trueBranch.toString() + ", " +
                falseBranch.toString() + ")");
    }
}
