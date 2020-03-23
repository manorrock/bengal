/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A whitespace.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Whitespace {

    /**
     * Stores the string.
     */
    private final String string;
    
    /**
     * Constructor.
     * 
     * @param string the string representation. 
     */
    public Whitespace(String string) {
        this.string = string;
    }

    /**
     * Returns the string representation.
     * 
     * @return the string representation.
     */
    @Override
    public String toString() {
        return string;
    }
}
