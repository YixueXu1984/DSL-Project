package parse;

import ast.*;
import general.Visitor;

import java.util.List;

public class ParseVisitor<AST> implements Visitor<AST> {

    private List<String> tokens;

    public ParseVisitor(List<String>tokens) {
        this.tokens = tokens;
    }

    @Override
    public AST visit(AST ast) {
        return null;
    }

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
    public AST visit(Program p) {

    }
}
