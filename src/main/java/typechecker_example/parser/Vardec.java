package typechecker_example.parser;

public class Vardec {
    public final Type type;
    public final Variable variable;

    public Vardec(final Type type,
                  final Variable variable) {
        this.type = type;
        this.variable = variable;
    }
}
