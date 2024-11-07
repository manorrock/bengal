/*
 * Copyright (c) 2002-2024 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.lexer;

/**
 * The 'class' lexer.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
class ClassLexer {
    
    /**
     * Stores buffer used.
     */
    private final StringBuilder buffer = new StringBuilder();
    
    /**
     * Process the character.
     * 
     * @param character the character.
     */
    public Token process(int character) {
        Token result = null;
        
        buffer.append((char) character);
        
        if (buffer.toString().equals("class")) {
            result = new ClassToken();
            reset();
        }
        
        return result;
    }
    
    /**
     * Reset.
     */
    public void reset() {
        buffer.setLength(0);
    }
}
