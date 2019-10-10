package ast;

import general.Visitor;

import java.util.Map;
import java.util.Set;

public class Node {

    public String label;

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
