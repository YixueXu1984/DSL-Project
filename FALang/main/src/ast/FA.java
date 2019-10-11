package ast;

import general.Visitor;

import java.util.Set;

public class FA extends AST  {

    public boolean isDFA;
    public String name;
    public Alphabet alphabet;
    public NodeList nodes;

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
