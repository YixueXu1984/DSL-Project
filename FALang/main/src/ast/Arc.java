package ast;

import general.Visitor;

public class Arc extends AST {

    public String fromNode;
    public String toNode;

    public AST accept(Visitor<AST> v) {
        return v.visit(this);
    }
}
