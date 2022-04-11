package typechecker_example.typechecker;

import typechecker_example.parser.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public Typechecker {
    public final Program program;
    public final Map<FunctionName, Fdef> functions;

    // Signature (usually): name, parameter types
    //
    // // same name, different signatures:
    // int foo(int x, bool y) { ... }
    // int foo(int x, int y) { ... }
    //
    // foo(5, true)
    // foo(int, bool)
    //
    public Typechecker(final Program program) throws TypeErrorException {
        this.program = program;
        functions = new HashMap<FunctionName, FDef>();
        for (final Fdef fdef : program.functions) {
            if (!functions.containsKey(fdef.fname)) {
                functions.put(fdef.fname, fdef);
            } else {
                throw new TypeErrorException("Function with duplicate name: " + fdef.fname);
            }
        }
    }

    public Fdef getFunctionByName(final FunctionName fname) throws TypeErrorException {
        final FDef fdef = functions.get(fname);
        if (fdef == null) {
            throw new TypeErrorException("No such function with name: " + fname);
        } else {
            return fdef;
        }
    }
    
    // int foo(int x, bool y) { ... }
    //
    // int x = foo(1, true);
    //
    // 1. Is foo a function?
    // 2. Does foo take an integer and a boolean? - (int, bool)
    // 3. Does foo return an integer?
    public static Type typeofFunctionCall(final FunctionCallExp exp,
                                          final Map<Variable, Type> typeEnvironment) throws TypeErrorException {
        // what are functions?  Are they data?  Are they somehow special?
        final Fdef fdef = getFunctionByName(exp.fname);
        if (exp.params.size() != fdef.arguments.size()) {
            throw new TypeErrorException("Wrong number of arguments for function: " + fdef.fname);
        }
        for (int index = 0; index < exp.params.size(); index++) {
            final Type receivedArgumentType = typeof(exp.params.get(index), typeEnvironment);
            final Type expectedArgumentType = fdef.arguments.get(index).type;
            // doesn't handle subtyping right now
            //
            // void foo(Animal a) { ... }
            //
            // foo(new Dog())
            if (!receivedArgumentType.equals(expectedArgumentType)) {
                throw new TypeErrorException("Type mismatch on function call argument");
            }
        }
        return fdef.returnType;
    }
    
    // op ::= + | < | &&
    public Type typeofOp(final OpExp exp,
                         final Map<Variable, Type> typeEnvironment) throws TypeErrorException {
        final Type leftType = typeof(exp.left, typeEnvironment);
        final Type rightType = typeof(exp.right, typeEnvironment);
        if (exp.op instanceof PlusOp) {
            if (leftType instanceof IntType && rightType instanceof IntType) {
                return new IntType();
            } else {
                throw new TypeErrorException("Incorrect types for +");
            }
        } else if (exp.op instanceof LessThanOp) {
            if (leftType instanceof IntType && rightType instanceof IntType) {
                return new BoolType();
            } else {
                throw new TypeErrorException("Incorrect types for <");
            }
        } else if (exp.op instanceof AndOp) {
            if (leftType instanceof BoolType && rightType instanceof BoolType) {
                return new BoolType();
            } else {
                throw new TypeErrorException("Incorrect types for &&");
            }
        } else {
            throw new TypeErrorException("Unsupported operation: " + exp.op);
        }
    }
    
    // type environment: Variable -> Type
    public Type typeof(final Exp exp,
                       final Map<Variable, Type> typeEnvironment) throws TypeErrorException {
        if (exp instanceof BooleanLiteralExp) {
            return new BoolType();
        } else if (exp instanceof IntegerLiteralExp) {
            return new IntType();
        } else if (exp instanceof VariableExp) {
            // needed: some way to track variables in scope,
            //         including the types they were declared as
            // int x = ...; // need to remeber that x is an int
            final Variable variable = ((VariableExp)exp).variable;
            final Type variableType = typeEnvironment.get(variable);
            // get returns null if the key isn't in the map
            if (variableType == null) {
                throw new TypeErrorException("variable not in scope: " + variable);
            } else {
                return variableType;
            }
        } else if (exp instanceof OpExp) {
            return typeofOpExp((OpExp)exp, typeEnvironment);
        } else if (exp instanceof FunctionCallExp) {
            return typeofFunctionCall((FunctionCallExp)exp, typeEnvironment);
        } else {
            throw new TypeErrorException("Unsupported expresssion: " + exp);
        }
    }

    // int x = 7;
    // while (...) {
    //   bool x = true; // remember: x is an integer
    //   // only the boolean available here
    //   // remember: reinstate x as an integer
    // }
    // // only the integer available here
    public Map<Variable, Type> typecheckStmt(final Stmt stmt,
                                             final Map<Variable, Type> typeEnvironment) throws TypeErrorException {
        ...
    }
}
