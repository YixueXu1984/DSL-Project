package ast;

import general.Visitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Alphabet extends AST  {

    public Map<String, ArcList> a;

    public Alphabet() {
        a = new HashMap<>();
    }

    public AST accept(Visitor<AST> v) {
        return v.visit(this);
    }
}
