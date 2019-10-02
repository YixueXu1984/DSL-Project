package tokenize;

import java.util.*;

public class Tokenizer {

    //Basic EBNF modifications should only require changing these two static fields
    public static String[] delimitors = {"{", "}", "(", ")", ",", ":", "->"};
    public static String skips = " \n\r";

    //helper
    private static String wrapAll(String s) {
        for(String d: delimitors) {
            s = s.replace(d, " " + d + " ");
        }
        return s;
    }

    public static List<String> tokenize(String program) {
        StringTokenizer st = new StringTokenizer(program, skips);
        List<String> tokens = new ArrayList<>();
        while(st.hasMoreTokens())
            tokens.addAll(Arrays.asList(Tokenizer.wrapAll(st.nextToken()).split(" ")));
        return tokens;
    }
}
