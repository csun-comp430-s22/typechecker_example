```
x is a variable
i is an integer
fname is a function name
op ::= + | < | &&
exp ::= true | false | x | i | exp op exp | fname(exp*)
type ::= int | bool
vardec ::= type x
stmt ::= vardec = exp; |
         if (exp) stmt else stmt |
         while (exp) stmt |
         return exp; |
         { stmt* }
fdef ::= type fname(vardec*) stmt
program ::= fdef*
```
