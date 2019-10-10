package general;

import ast.*;

public interface Visitor<T> {
    T visit(AST ast);

    T visit(Alphabet a);

    T visit(Arc a);

    T visit(FA fa);

    T visit(Node n);

    T visit(NodeList nl);

    T visit(Program p);

    T visit(ArcList al);
}
