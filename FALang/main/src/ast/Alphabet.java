package ast;

import general.Visitor;

import java.util.HashSet;
import java.util.Set;

public class Alphabet extends AST  {

    public Set<String> chares;
    public Set<Arc> arcs;

    public Alphabet() {
        arcs = new HashSet<>();
        chares = new HashSet<>();
    }

    public AST accept(Visitor<AST> v) {
        return v.visit(this);
    }
}
