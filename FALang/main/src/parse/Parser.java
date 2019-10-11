package parse;

import ast.*;

public class Parser {

    public static Program parse() {
        return (Program) (new ParseVisitor()).visit(new Program());
    }
}
