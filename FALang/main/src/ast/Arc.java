package ast;

import general.Visitor;

public class Arc extends AST {

    public String fromNode;
    public String toNode;

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
