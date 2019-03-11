/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.ast;

/**
 * An AstObject.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstObject {

    /**
     * Stores the name.
     */
    private String name;
    
    /**
     * Constructor.
     */
    public AstObject() {
    }
    
    /**
     * Constructor.
     * 
     * @param name the name. 
     */
    public AstObject(String name) {
        this.name = name;
    }
    
    /**
     * Get the name.
     * 
     * @return the name.
     */
    public String getName() {
        return name;
    }
}
