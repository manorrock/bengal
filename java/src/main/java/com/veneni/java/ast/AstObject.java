/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * An AstObject.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstObject {

    /**
     * Stores the methods.
     */
    private List<AstMethod> methods;
    
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
        this.methods = new ArrayList<>();
        this.name = name;
    }
    
    /**
     * Get the methods.
     * 
     * @return the methods.
     */
    public List<AstMethod> getMethods() {
        return methods;
    }
    
    /**
     * Get the name.
     * 
     * @return the name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the methods.
     * 
     * @param methods the methods.
     */
    public void setMethods(List<AstMethod> methods) {
        this.methods = methods;
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
