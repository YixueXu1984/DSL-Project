package general;

import ast.Program;
import parse.Parser;
import tokenize.Tokenizer;
import translate.Translator;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Interpreter {

    // Tokenizer -> tokens
    // Parser : new ParseVisitor(tokens)

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        List<String> literals = Arrays.asList( "{", "}", "(", ")", ",", ":");
        Tokenizer.makeTokenizer("input.txt", literals);
        Program program = Parser.parse();

        Translator.setWriter("output.txt");
        String result = Translator.translate(program);

        Translator.closeWriter();

    }
}
