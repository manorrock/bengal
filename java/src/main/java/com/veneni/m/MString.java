/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A string in the Veneni-M language.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MString {
    
    /**
     * Stores the string.
     */
    private String string;
    
    /**
     * Constructor.
     */
    public MString() {
        string = "";
    }
    
    /**
     * Constructor.
     * 
     * @param string the string.
     */
    public MString(String string) {
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
