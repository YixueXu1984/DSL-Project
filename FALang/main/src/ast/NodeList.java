package ast;

import general.Visitor;

import java.util.HashSet;
import java.util.Set;

public class NodeList extends AST {

    public Set<Node> nodes;

    public NodeList() {
        nodes = new HashSet<>();
    }

    public AST accept(Visitor<AST> v) {
        return v.visit(this);
    }
}
