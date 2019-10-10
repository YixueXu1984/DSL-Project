package parse;

import ast.*;
import general.Visitor;
import tokenize.Tokenizer;

public class ParseVisitor<AST> implements Visitor<AST> {

    protected Tokenizer tokenizer = Tokenizer.getTokenizer();

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
        switch (tokenizer.getNext()) {
            case "DFA":
                fa.isDFA = true;
                break;
            case "NFA":
                fa.isDFA = false;
                break;
            default:
                throw new ParseError("Expected either 'NFA' or 'DFA'");
        }
        tokenizer.getAndCheckNext("(");
        fa.name = tokenizer.getNext();
        tokenizer.getAndCheckNext(")");
        tokenizer.getAndCheckNext("{");
        fa.a = (Alphabet) this.visit(new Alphabet());
        tokenizer.getAndCheckNext("}");
        tokenizer.getAndCheckNext("{");
        fa.nodes = (NodeList) this.visit(new NodeList());
        tokenizer.getAndCheckNext("}");
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
