/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A method in the Veneni-M language.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MMethod {
    
    /**
     * Stores the name.
     */
    private String name;
    
    /**
     * Constructor.
     */
    public MMethod() {
    }
    
    /**
     * Constructor.
     * 
     * @param name the name.
     */
    public MMethod(String name) {
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
