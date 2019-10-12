package tokenize;

import parse.ParseError;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Tokenizer {

    private static String program;
    private static List<String> literals;
    private String[] tokens;
    private int currentToken = 0;
    private static Tokenizer theTokenizer;


    private Tokenizer(String filename, List<String> literalsList){
        literals = literalsList;
        try {
            program = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Didn't find file" + e.getLocalizedMessage());
            System.exit(0);
        }
        tokenize();
    }

    private void  tokenize() {

        String tokenizedProgram = program;
        tokenizedProgram = tokenizedProgram.replace("\n","");
        tokenizedProgram = tokenizedProgram.replace("\r","");


        for (String s : literals){
            tokenizedProgram = tokenizedProgram.replace(s,"_"+s+"_");
        }

        tokenizedProgram = tokenizedProgram.replaceAll("[ ]+","");
        tokens= tokenizedProgram.split("[_]+");

        System.out.println(Arrays.asList(tokens));
    }


    public static void makeTokenizer(String filename, List<String> literals){
        if (theTokenizer==null){
            theTokenizer = new Tokenizer(filename,literals);
        }
    }

    private String checkNext(){
        String token="";
        if (currentToken<tokens.length){
            token = tokens[currentToken];
        }
        else {
            throw new ParseError("Expected Additional Tokens");
        }
        return token;
    }

    public String getNext(){
        String token="";
        if (currentToken<tokens.length){
            token = tokens[currentToken];
            currentToken++;
        }
        else {
            throw new ParseError("Expected Additional Tokens");
        }

        return token;
    }

    public String getAndCheckNext(String regexp){
        String s = getNext();
        if (!s.matches(regexp)) {
            throw new ParseError("Expected "+ regexp + " but got " + s + " when parsing ");
        }
        return s;
    }

    public boolean checkToken(String regexp){
        String s = checkNext();
        return (s.matches(regexp));
    }

    public boolean moreTokens(){
        return currentToken<tokens.length;
    }


    public static Tokenizer getTokenizer(){
        return theTokenizer;
    }
}
