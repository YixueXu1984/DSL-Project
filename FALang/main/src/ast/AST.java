package ast;

import general.Visitor;

public abstract class AST {

    public abstract <T> T accept(Visitor<T> v);
}
