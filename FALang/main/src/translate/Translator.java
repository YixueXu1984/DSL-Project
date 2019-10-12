package translate;

import ast.Program;
import typeCheck.TypeChecker;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Translator {

    public static PrintWriter writer;
    public static void setWriter(String name) throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter(name, "UTF-8");
    }
    public static void closeWriter(){
        writer.close();
    }


    public static String translate(Program parsed) {
        return  (new TranslateVisitor()).visit(parsed);
    }
}
