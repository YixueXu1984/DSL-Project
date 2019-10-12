package NameCheck;

import ast.*;
import general.Visitor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("ALL")
public class NameCheckVisitor<AST> implements Visitor<AST> {




    @Override
    public AST visit(ast.AST ast) {
        return null;
    }

    @Override
    public AST visit(Alphabet a) {
        for(String charE: a.alphabetToArcs.keySet()) {
            //check alphabets are valid character
            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(charE);
            boolean b = (m.find());
            if (charE.equals("\\e")) {
                b=false;
            }

            if (b) {
                throw new Error("Wrong alphabet type: expect a letter or a number");
            }

            Set<Arc> arcList = a.alphabetToArcs.get(charE).arcs;
            Arc[] arcs = arcList.toArray(new Arc[0]);
            for (int i=0;i<arcList.size();i++) {
                arcs[i].accept(this);
            }
        }




        return (AST) a;
    }

    @Override
    public AST visit(Arc a) {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher mFrom = p.matcher(a.fromNode);
        boolean b = mFrom.find();
        if (b){
            throw new Error("An arc must start from a valid state: state name contains special characters."
                    + " Please fix the "+ a.fromNode + " from (" + a.fromNode + ", " + a.toNode + ").");
        }


        Matcher mTo = p.matcher(a.toNode);
        boolean c = mTo.find();
        if (c){
            throw new Error("An arc must start from a valid state: state name contains special characters."
                    + " Please fix the "+ a.toNode + " from (" + a.fromNode + ", " + a.toNode + ").");
        }
    return (AST) a;
    }

    @Override
    public AST visit(FA fa) {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(fa.name);
        boolean b = m.find();
        if (b){
            throw new Error("State Machine name contains special character");
        }

        fa.alphabet.accept(this);
        fa.nodes.accept(this);


        return (AST) fa;
    }

    @Override
    public AST visit(Node n) {
        return null;
    }

    @Override
    public AST visit(NodeList nl) {
        return (AST) nl;
    }

    @Override
    public AST visit(Program p) {
        p.finiteAutomata.accept(this);
        return (AST) p;
    }

    @Override
    public AST visit(ArcList al) {
        return null;
    }
}
