package ast;

import general.Visitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NodeList extends AST {

    public ArrayList<Node> nodes;

    public NodeList() {
        nodes = new ArrayList<>();
    }

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
