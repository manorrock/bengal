/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.ast;

/**
 * An AST character.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstCharacter {

    /**
     * Stores the character.
     */
    private final String character;
    
    /**
     * Constructor.
     * 
     * @param character the character (in string format). 
     */
    public AstCharacter(String character) {
        this.character = character;
    }
}
