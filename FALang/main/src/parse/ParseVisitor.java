package parse;

import ast.*;
import general.Visitor;

import java.util.Iterator;
import java.util.List;

public class ParseVisitor<AST> implements Visitor<AST> {

    private Iterator<String> tokens;

    private boolean getAndCheckNext(String s) {
        if(tokens.hasNext())
            return tokens.next().equals(s);
        else
            throw new ParseError("Expected Additional Tokens");
    }

    private String getNext() {
        if(tokens.hasNext())
            return tokens.next();
        else
            throw new ParseError("Expected Additional Tokens");
    }

    public ParseVisitor(List<String>tokens) {
        this.tokens = tokens.iterator();
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
        switch (getNext()) {
            case "DFA":
                fa.isDFA = true;
                break;
            case "NFA":
                fa.isDFA = false;
                break;
            default:
                throw new ParseError("Expected either 'NFA' or 'DFA'");
        }
        getAndCheckNext("(");
        fa.name = getNext();
        getAndCheckNext(")");
        getAndCheckNext("{");
        fa.a = (Alphabet) this.visit(new Alphabet());
        getAndCheckNext("}");
        getAndCheckNext("{");
        fa.nodes = (NodeList) this.visit(new NodeList());
        getAndCheckNext("}");
        return (AST) fa;
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
        p.finiteAutomata = (FA) this.visit(new FA());
        return (AST) p;
    }
}
