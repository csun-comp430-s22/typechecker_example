package typechecker_example.parser;

public class IntType implements Type {
    public IntType() {}

    public int hashCode() {
        return 0;
    }
    
    public boolean equals(final Object other) {
        return other instanceof IntType;
    }

    public String toString() {
        return "IntType";
    }
}
