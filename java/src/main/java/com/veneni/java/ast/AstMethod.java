/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.ast;

/**
 * An AstMethod.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstMethod {
    
    /**
     * Stores the name.
     */
    private String name;
    
    /**
     * Constructor.
     */
    public AstMethod() {
    }
    
    /**
     * Constructor.
     * 
     * @param name the name.
     */
    public AstMethod(String name) {
        this.name = name;
    }

    /**
     * Get the name.
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     * 
     * @param name the name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
