package ast;

import general.Visitor;

import java.util.Set;

public class FA extends AST  {

    private boolean isDFA;
    private Alphabet a;
    private Set<Node> nodes;

    public AST accept(Visitor<AST> v) {
        return v.visit(this);
    }
}
