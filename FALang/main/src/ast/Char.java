package ast;

import general.Visitor;

public class Char extends AST  {

    public String c;

    public AST accept(Visitor<AST> v) {
        return v.visit(this);
    }
}
