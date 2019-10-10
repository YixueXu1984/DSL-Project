package ast;

import general.Visitor;
import tokenize.Tokenizer;

public abstract class AST {

    public abstract AST accept(Visitor<AST> v);
}
