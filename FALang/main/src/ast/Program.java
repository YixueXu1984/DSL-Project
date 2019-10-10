package ast;

import general.Visitor;

public class Program extends AST {

    public FA finiteAutomata;

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }

}
