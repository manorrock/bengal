/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A comment.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Comment {

    /**
     * Stores the string.
     */
    private final String string;
    
    /**
     * Constructor.
     * 
     * @param string the string representation. 
     */
    public Comment(String string) {
        this.string = string;
    }
    
    /**
     * Get the string.
     * 
     * @return the string.
     */
    public String getString() {
        return string;
    }
}
