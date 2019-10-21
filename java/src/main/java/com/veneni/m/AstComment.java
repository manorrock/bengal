/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * An AST comment.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstComment {

    /**
     * Stores the string.
     */
    private final String string;
    
    /**
     * Constructor.
     * 
     * @param string the string representation. 
     */
    public AstComment(String string) {
        this.string = string;
    }
}
