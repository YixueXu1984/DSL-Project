package typeCheck;

import ast.*;
import general.Visitor;

import java.util.BitSet;
import java.util.Set;

public class TypeCheckVisitor implements Visitor<AST> {

    private Set<String> states;
    private boolean isDFA;

    @Override
    public AST visit(AST ast) {
        return null;
    }

    @Override
    public AST visit(Alphabet a) {
        for(String charE: a.a.keySet()) {
            //check valid alphabet character
        }
        for(ArcList al: a.a.values()) {
            //check all states have an outgoing edge for each charE (exactly one in case of DFA)
        }
        return (AST) a;
    }

    @Override
    public AST visit(Arc a) {
        //check both ends in states
        return null;
    }

    @Override
    public AST visit(FA fa) {
        //assign isDFA flag
        return null;
    }

    @Override
    public AST visit(Node n) {
        //Check valid state name and not duplicate
        return null;
    }

    @Override
    public AST visit(NodeList nl) {
        //add all states to private field
        return null;
    }

    @Override
    public AST visit(Program p) {
        //
        return null;
    }

    @Override
    public AST visit(ArcList al) {
        //
        return null;
    }
}
