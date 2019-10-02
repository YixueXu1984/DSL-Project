package parse;

import ast.AST;
import ast.Program;
import tokenize.Tokenizer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public static Set<String> reservedWords = Stream.of("DFA", "NFA", "start", "terminal").
            collect(Collectors.toCollection(HashSet::new));
    public static Set<String> punctuation = new HashSet<>(Arrays.asList(Tokenizer.delimitors));

    public static Program parse(List<String> tokens) {
        Iterator<String> tokenITR = tokens.iterator();
        AST program = new Program(), currentAST = program;
        String currentToken;
        while(tokenITR.hasNext()) {
            currentToken = tokenITR.next();
            switch (currentToken) {
                //These are the only cases we need to switch on,
                // the remaining AST nodes/tokens are contextualized by currentAST
                case "DFA":
                case "NFA":
                case "start":
                case "terminal":
                default:
                    continue;
            }
        }
        return (Program) program;
    }
}
