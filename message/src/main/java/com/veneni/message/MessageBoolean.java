/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.message;

/**
 * A Veneni Message boolean.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MessageBoolean {
    
    /**
     * Stores the boolean value.
     */
    private boolean value;
    
    /**
     * Get the boolean value.
     * 
     * @return the boolean value.
     */
    public boolean getBoolean() {
        return value;
    }
    
    /**
     * Set the boolean value.
     * 
     * @param value the boolean value.
     */
    public void setBoolean(boolean value) {
        this.value = value;
    }
    
    /**
     * Translate it to Java.
     * 
     * @return the Java representation.
     */
    public String toJava() {
        return Boolean.toString(value);
    }
}
