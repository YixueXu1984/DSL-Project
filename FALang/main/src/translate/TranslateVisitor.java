package translate;

import ast.*;
import general.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TranslateVisitor implements Visitor<String> {

    // Used for node positioning
    int xPosition = 0;
    int xMax = 14;
    int yPosition = 0;
    int yMax = 4;
    int spacing = 2;

    @Override
    public String visit(AST ast) { return null; }

    @Override
    public String visit(Alphabet a) {

        // Build mapping of arc to Alphabet
        Map<Arc, ArrayList<String>> arcsToAlphabet = new HashMap<>();

        a.alphabetToArcs.forEach((symbol, arcList) -> {
            String alphabetSymbol = symbol.equals("\\e") ? "$\\epsilon$" : symbol;

            arcList.arcs.forEach((arc -> {

                ArrayList<String> alphabets = arcsToAlphabet.get(arc);
                if(alphabets == null){
                    alphabets = new ArrayList();
                }
                alphabets.add(alphabetSymbol);
                arcsToAlphabet.put(arc, alphabets);
            }));
        });

        // Draw edges
        arcsToAlphabet.forEach((arc, alphabetList) -> {

            String arcDetail = arc.fromNode.equals(arc.toNode) ? "[loop below] " : "[bend left] ";

            String alphabetListFormatted = String.join(",", alphabetList);

            Translator.writer.println("\\draw (" + arc.fromNode + ") " +
                    "edge" + arcDetail + "node " +
                    "{\\tt " + alphabetListFormatted + "} " +
                    "( " + arc.toNode + "); "
            );
        });

        return null;
    }

    @Override
    public String visit(Arc a) {
        return null;
    }

    @Override
    public String visit(FA fa) {

        for(Node node : fa.nodes.nodes) {
            node.accept(this);
        }

        fa.alphabet.accept(this);

        return null;
    }

    @Override
    public String visit(Node n) {

        if(n.isAccept){
            Translator.writer.print("\\node[state, accepting] ");
        } else if(n.isStart){
            Translator.writer.print("\\node[state, initial] ");
        } else {
            Translator.writer.print("\\node[state] ");
        }

        // Starting node should always be leftmost
        Translator.writer.print("at "  + handleCoordinates(n));

        Translator.writer.print("(" + n.label + ") ");
        Translator.writer.print("{$" + n.label + "$}; \n");


        return null;
    }

    @Override
    public String visit(NodeList nl) {
        return null;
    }

    @Override
    public String visit(Program p) {
        String preamble =
                "\\documentclass[12pt]{article}\n" +
                "\\usepackage{tikz}\n" +
                "\\usetikzlibrary{automata, positioning, arrows}" +
                "\\begin{document}\n" +
                "\\begin{tikzpicture}[->,>=stealth',shorten >=1pt,auto,node distance=3.5cm, scale = 1,transform shape]\n";

        String postamble =
                "\\end{tikzpicture}\n" +
                "\\end{document}";

        Translator.writer.println(preamble);
        p.finiteAutomata.accept(this);
        Translator.writer.println(postamble);

        return "DONE";
    }

    @Override
    public String visit(ArcList al) {
        al.arcs.forEach((arc) -> {
            arc.accept(this);
        });
        return null;
    }

    private String handleCoordinates(Node n) {

        if(n.isStart){
            return "(0,0) ";
        } else {

            int originalY = yPosition;

            if (xPosition >= xMax && yPosition < yMax){
                // Overflow on right side of page, go up (assuming ymax is not reached)
                yPosition = yPosition + spacing;
            }

            if (originalY >= yMax)
            {
                // Overflow on top move left
                xPosition = xPosition - spacing ;
            } else if(xPosition < xMax){
                // Keep moving right
                xPosition = xPosition + spacing ;
            }

            return ("(" +xPosition + "," + yPosition + ") ");
        }
    }
}
