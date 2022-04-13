package typechecker_example.typechecker;

import typechecker_example.parser.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TypecheckerTest {
    @Test
    public void testTypeofBoolean() throws TypeErrorException {
        // true -> bool
        final Typechecker typechecker =
            new Typechecker(new Program(new ArrayList<Fdef>()));
        final Map<Variable, Type> typeEnvironment =
            new HashMap<Variable, Type>();
        
        final Type receivedType = typechecker.typeof(new BooleanLiteralExp(true),
                                                     typeEnvironment);
        assertEquals(new BoolType(), receivedType);
    }
}
