package parse;

import ast.*;
import tokenize.Tokenizer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public static Set<String> reservedWords = Stream.of("FA", "NFA", "start", "accepting").
            collect(Collectors.toCollection(HashSet::new));
    public static Set<String> punctuation = new HashSet<>(Arrays.asList(Tokenizer.delimitors));

    public Program parse(List<String> tokens) {

        return (Program) (new ParseVisitor<AST>(tokens)).visit(new Program());
    }
}
