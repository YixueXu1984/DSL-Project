package translate;

import ast.*;
import general.Visitor;

public class TranslateVisitor<AST> implements Visitor<AST> {

    @Override
    public AST visit(AST ast) { return null; }

    @Override
    public AST visit(Alphabet a) {
        return null;
    }

    @Override
    public AST visit(Arc a) {
        return null;
    }

    @Override
    public AST visit(FA fa) {
        return null;
    }

    @Override
    public AST visit(Node n) {
        return null;
    }

    @Override
    public AST visit(NodeList nl) {
        return null;
    }

    @Override
    public AST visit(Program p) {
        return null;
    }
}
