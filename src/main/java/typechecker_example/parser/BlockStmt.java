package typechecker_example.parser;

import java.util.List;

public class BlockStmt implements Stmt {
    final List<Stmt> body;

    public BlockStmt(final List<Stmt> body) {
        this.body = body;
    }
}
