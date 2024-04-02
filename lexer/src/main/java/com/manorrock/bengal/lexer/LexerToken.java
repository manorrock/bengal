package com.manorrock.bengal.lexer;

/**
 * A lexer token.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class LexerToken {
    
    /**
     * Stores the token.
     */
    private String token;
    
    /**
     * Stores the line number.
     */
    private int lineNumber;

    /**
     * Constructor.
     * 
     * @param token the token.
     * @param lineNumber the line number.
     */
    public LexerToken(String token, int lineNumber) {
        this.token = token;
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return token + " at line " + lineNumber;
    }
}
