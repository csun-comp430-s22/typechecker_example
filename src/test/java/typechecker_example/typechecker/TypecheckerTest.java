package typechecker_example.typechecker;

import typechecker_example.parser.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TypecheckerTest {
    public static final Map<Variable, Type> emptyTypeEnvironment =
        new HashMap<Variable, Type>();

    public static Type typeof(final Exp exp) throws TypeErrorException {
        // idealized lexer:
        // public static List<Token> tokenize(final String input);
        //
        // idealized parser:
        // public static Program parse(final List<Token> tokens);
        //
        // new Typechecker(parse(tokenize("")))
        // final String input =
        //   "int add(int x, int y) { return x + y; }\n" +
        //   "int main() { return add(2, 3); }\n";
        // new Typechecker(parse(tokenize(input)));
        //
        // new Program(Arrays.asList(new Fdef[]{ new Fdef(new FunctionName("add")...
        final Typechecker emptyTypechecker =
            new Typechecker(new Program(new ArrayList<Fdef>()));
        return emptyTypechecker.typeof(exp, emptyTypeEnvironment);
    }
    
    @Test
    public void testTypeofBoolean() throws TypeErrorException {
        // true -> bool
        assertEquals(new BoolType(),
                     typeof(new BooleanLiteralExp(true)));
    }

    @Test
    public void testTypeofInteger() throws TypeErrorException {
        // 1 -> int
        assertEquals(new IntType(),
                     typeof(new IntegerLiteralExp(1)));
    }
}
