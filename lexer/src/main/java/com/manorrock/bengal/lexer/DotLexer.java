/*
 * Copyright (c) 2002-2024 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.lexer;

/**
 * The '.' lexer.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
class DotLexer {
    
    /**
     * Process the character.
     * 
     * @param character the character.
     */
    public Token process(int character) {
        Token result;
        
        if (character == '.') {
            result = new Dot();
        } else {
            result = null;
        }
        
        return result;
    }
}
