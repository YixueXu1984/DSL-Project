package translate;

import ast.*;
import general.Visitor;

public class TranslateVisitor implements Visitor<String> {

    private String concat(String ... strs) {
        String output = "";
        for(String str: strs)
            output += str + " \n";
        return output;
    }

    @Override
    public String visit(AST ast) { return null; }

    @Override
    public String visit(Alphabet a) {
        return null;
    }

    @Override
    public String visit(Arc a) {
        return null;
    }

    @Override
    public String visit(FA fa) {
        return null;
    }

    @Override
    public String visit(Node n) {
        return null;
    }

    @Override
    public String visit(NodeList nl) {
        return null;
    }

    @Override
    public String visit(Program p) {
        String imports = "";
        String init = "";
        return concat(imports, init, p.finiteAutomata.accept(this));
    }

    @Override
    public String visit(ArcList al) {
        return null;
    }
}
