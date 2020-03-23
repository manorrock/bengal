/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A character.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Char {

    /**
     * Stores the character.
     */
    private final char character;
    
    /**
     * Constructor.
     *
     * @param character the character.
     */
    public Char(char character) {
        this.character = character;
    }

    /**
     * Eguals.
     * 
     * @param object the object to compare.
     * @return true if equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object instanceof Char) {
            Char compare = (Char) object;
            result = compare.character == character;
        }
        return result;
    }

    /**
     * Hash code.
     * 
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.character;
        return hash;
    }

    /**
     * Return the char representation.
     * 
     * @return the char representation.
     */
    public char toChar() {
        return character;
    }
    
    /**
     * Return the string representation.
     * 
     * @return the string representation.
     */
    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
