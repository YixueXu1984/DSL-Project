package ast;

import general.Visitor;

public class Program extends AST {

    public FA finiteAutomata;

    public AST accept(Visitor<AST> v) {
        return v.visit(this);
    }

}
