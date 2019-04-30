/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A (string of) whitespace.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MWhitespace {
    
    /**
     * Stores the whitespace.
     */
    private String whitespace;

    /**
     * Constructor.
     * 
     * @param whitespace the whitespace. 
     */
    public MWhitespace(String whitespace) {
        this.whitespace = whitespace;
    }

    /**
     * Get the whitespace.
     * 
     * @return the whitespace.
     */
    public String getWhitespace() {
        return whitespace;
    }

    /**
     * Set the whitespace.
     * 
     * @param whitespace the whitespace.
     */
    public void setWhitespace(String whitespace) {
        this.whitespace = whitespace;
    }
}
