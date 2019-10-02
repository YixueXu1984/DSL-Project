package ast;

import general.Visitor;

public class Arc extends AST {

    public String toNode;
    public Char c;

    public AST accept(Visitor<AST> v) {
        return v.visit(this);
    }
}
