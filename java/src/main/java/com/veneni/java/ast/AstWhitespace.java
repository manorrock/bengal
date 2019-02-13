/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.ast;

/**
 * A (string of) whitespace.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstWhitespace {
    
    /**
     * Stores the whitespace.
     */
    private final String whitespace;

    /**
     * Constructor.
     * 
     * @param whitespace the whitespace. 
     */
    public AstWhitespace(String whitespace) {
        this.whitespace = whitespace;
    }
}
