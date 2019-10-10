package general;

import ast.*;

public interface Visitor<AST> {
    AST visit(AST ast);

    AST visit(Alphabet a);

    AST visit(Arc a);

    AST visit(FA fa);

    AST visit(Node n);

    AST visit(NodeList nl);

    AST visit(Program p);

    AST visit(ArcList al);
}
