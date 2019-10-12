package NameCheck;

import ast.*;

public class NameChecker {

    public static Program check(Program p) {
        return (Program) (new NameCheckVisitor()).visit(p);
    }
}
