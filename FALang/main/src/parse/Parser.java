package parse;

import ast.*;

import java.util.*;
public class Parser {

    public Program parse(List<String> tokens) {
        return (Program) (new ParseVisitor<AST>()).visit(new Program());
    }
}
