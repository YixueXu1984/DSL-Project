package parse;

import ast.*;
import general.Visitor;
import tokenize.Tokenizer;

public class ParseVisitor implements Visitor<AST> {

    protected Tokenizer tokenizer = Tokenizer.getTokenizer();

    @Override
    public AST visit(AST ast) {
        return null;
    }

    @Override
    public AST visit(Alphabet a) {
        while(!tokenizer.checkToken("\\}")){
            String symbol = tokenizer.getNext();
            ArcList arcList = (ArcList) this.visit(new ArcList());
            a.alphabetToArcs.put(symbol, arcList);
        }
        return a;
    }

    @Override
    public AST visit(Arc a) {
        tokenizer.getAndCheckNext("\\(");
        a.fromNode = tokenizer.getNext();
        tokenizer.getAndCheckNext("\\,");
        a.toNode = tokenizer.getNext();
        tokenizer.getAndCheckNext("\\)");
        return a;
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
        tokenizer.getAndCheckNext("\\(");
        fa.name = tokenizer.getNext();
        tokenizer.getAndCheckNext("\\)");
        tokenizer.getAndCheckNext("\\{");
        fa.nodes = (NodeList) this.visit(new NodeList());
        tokenizer.getAndCheckNext("\\}");
        tokenizer.getAndCheckNext("\\{");
        fa.alphabet = (Alphabet) this.visit(new Alphabet());
        tokenizer.getAndCheckNext("\\}");
        return fa;
    }

    @Override
    public AST visit(Node n) {
        String label = tokenizer.getNext();

        if(tokenizer.checkToken("\\(")) {
            // Handle start or accept
            tokenizer.getNext();
            if(tokenizer.checkToken("start")){
                n.isStart = true;
                tokenizer.getNext();
            }else if(tokenizer.checkToken("accept")){
                n.isAccept = true;
                tokenizer.getNext();
            }else{
                throw new ParseError("Expected start or accept");
            }
            tokenizer.getAndCheckNext("\\)");
        }

        if(tokenizer.checkToken("\\,")){
            tokenizer.getNext();
        }

        n.label=label;
        return n;
    }

    @Override
    public AST visit(NodeList nl) {
        while(!tokenizer.checkToken("\\}")) {
            Node node = (Node) this.visit(new Node());
            nl.nodes.add(node);
        }
        return nl;
    }

    @Override
    public AST visit(Program p) {
        p.finiteAutomata = (FA) this.visit(new FA());
        return p;
    }

    @Override
    public AST visit(ArcList al) {
        tokenizer.getAndCheckNext(":");
        tokenizer.getAndCheckNext("\\{");
        while(!tokenizer.checkToken("\\}")) {
            Arc arc = (Arc) this.visit(new Arc());
            if(tokenizer.checkToken("\\,")){
                tokenizer.getNext();
            }
            al.arcs.add(arc);
        }
        tokenizer.getAndCheckNext("\\}");
        return al;
    }
}
