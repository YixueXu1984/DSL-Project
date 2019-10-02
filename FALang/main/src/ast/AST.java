package ast;

import general.Visitor;

public abstract class AST {

    public abstract AST accept(Visitor<AST> v);
}
