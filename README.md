Goal: determine the type of every expression in the program
- 1: int
- 1 + 2: int
- true: bool
- true && false: bool

```
x is a variable
i is an integer
fname is a function name
op ::= + | < | &&

1 < 2: bool
true < false: NO TYPE - type error

int addTwo(int x, int y) { return x + y; }

int x = addTwo(1, 2); // ok
bool y = addTwo(1, 2); // type error - bool and int are different types
int z = addTwo(true, false); // type error - parameter type mismatch

int x = 17;
int y = x + x; // ok - x declared as int

bool x = true;
int y = x + x; // type error - + only works for integers

int y = x + x; // type error - x not declared

need to keep track of:
- Variables in scope (and their types)
- Functions in scope (and their parameter / return types)

types:  bool   bool  | (depends on declared type) | int | (depends on operator) | (depends on return type)
exp ::= true | false | x                          | i   | exp op exp            | fname(exp*)

type ::= int | bool
vardec ::= type x
stmt ::= vardec = exp; |
         if (exp) stmt else stmt |
         while (exp) stmt |
         return exp; |
         { stmt* } |
         var[exp] = exp
fdef ::= type fname(vardec*) stmt
program ::= fdef*
```

# Evaluation / Interpretation
1 + 2 => 3
if (2 < 3) { return 4; } else { return 5; }

evaluator / interpreter: function that takes an AST and executes it as a program
- 1 + 2 = 3

typechecker: function that takes an AST and determines its type
- int + int = int

```
int myFunction() {
  if (int < int) { return int; } else { return int; }
}
```

- `true < false`: type error
