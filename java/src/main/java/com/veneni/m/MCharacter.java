/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A character in the Veneni-M language.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MCharacter {

    /**
     * Stores the character.
     */
    private String character;
    
    /**
     * Constructor.
     * 
     * @param character the character (in string format). 
     */
    public MCharacter(String character) {
        this.character = character;
    }

    /**
     * Get the character.
     * 
     * @return the character.
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Set the character.
     * 
     * @param character the character.
     */
    public void setCharacter(String character) {
        this.character = character;
    }
}
