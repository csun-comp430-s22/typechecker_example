package typechecker_example.parser;

public class AndOp implements Op {
    public AndOp() {}

    public int hashCode() {
        return 2;
    }

    public boolean equals(final Object other) {
        return other instanceof AndOp;
    }

    public String toString() {
        return "AndOp";
    }
}
