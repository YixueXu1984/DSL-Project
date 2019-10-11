package general;

import ast.Program;
import parse.Parser;
import tokenize.Tokenizer;

import java.util.Arrays;
import java.util.List;

public class Interpreter {

    // Tokenizer -> tokens
    // Parser : new ParseVisitor(tokens)

    public static void main(String[] args) {


        List<String> literals = Arrays.asList( "{", "}", "(", ")", ",", ":");
        Tokenizer.makeTokenizer("input.txt", literals);
        Program program = Parser.parse();
    }
}
