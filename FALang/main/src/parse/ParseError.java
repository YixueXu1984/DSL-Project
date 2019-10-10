package parse;

public class ParseError extends Error {

    public String msg;

    public ParseError(String msg) {
        this.msg = msg;
    }
}
