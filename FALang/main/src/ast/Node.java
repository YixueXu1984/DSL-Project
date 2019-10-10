package ast;

import general.Visitor;

import java.util.Map;
import java.util.Set;

public class Node {

    public String label;

    public AST accept(Visitor<AST> v) {
        return v.visit(this);
    }
}
