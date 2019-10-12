package parse;

import translate.Translator;

public class ParseError extends Error {

    public String msg;

    public ParseError(String msg) {
        this.msg = msg;
        Translator.writer.println(msg);
        Translator.closeWriter();
        System.out.println(msg);
    }
}
