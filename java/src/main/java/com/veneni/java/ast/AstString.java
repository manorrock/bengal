/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.ast;

/**
 * An AST string.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstString {
    
    /**
     * Stores the string.
     */
    private String string;
    
    /**
     * Constructor.
     */
    public AstString() {
        string = "";
    }
    
    /**
     * Constructor.
     * 
     * @param string the string.
     */
    public AstString(String string) {
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
    
    /**
     * Set the string.
     * 
     * @param string the string.
     */
    public void setString(String string) {
        this.string = string;
    }
}
