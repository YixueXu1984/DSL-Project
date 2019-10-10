package ast;

import general.Visitor;
import tokenize.Tokenizer;

public abstract class AST {

    public abstract <T> T accept(Visitor<T> v);
}
