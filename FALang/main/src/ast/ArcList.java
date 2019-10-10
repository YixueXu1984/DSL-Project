package ast;

import general.Visitor;

import java.util.HashSet;
import java.util.Set;

public class ArcList extends AST {

    public Set<Arc> arcs;

    public ArcList() {
        arcs = new HashSet<>();
    }

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
