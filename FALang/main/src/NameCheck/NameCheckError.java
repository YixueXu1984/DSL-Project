package NameCheck;

import translate.Translator;

public class NameCheckError extends Error {

    public String msg;

    public NameCheckError(String msg) {
        this.msg = msg;
        Translator.writer.println(msg);
        Translator.closeWriter();
        System.out.println(msg);
    }
}
