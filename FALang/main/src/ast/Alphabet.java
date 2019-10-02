package ast;

import general.Visitor;

public class Alphabet extends AST  {

    public AST accept(Visitor<AST> v) {
        return v.visit(this);
    }
}
