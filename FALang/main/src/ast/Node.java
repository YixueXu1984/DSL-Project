package ast;

import general.Visitor;

import java.util.Map;
import java.util.Set;

public class Node extends AST{

    public String label;
    public boolean isStart;
    public boolean isAccept;

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
