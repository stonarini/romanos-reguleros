package edu.poniperro;

public class RegexNumeroRomanos {

    private String regex;

    public RegexNumeroRomanos() {
        this.initRegex();
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    private void initRegex() {
        setRegex("I[XV]|X[CL]|C[MD]|[MCDLXVI]");
    }

}
