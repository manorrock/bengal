/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;

/**
 * An object in the Veneni-M language.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MObject {

    /**
     * Stores the methods.
     */
    private List<MMethod> methods;
    
    /**
     * Stores the name.
     */
    private String name;
    
    /**
     * Constructor.
     */
    public MObject() {
    }
    
    /**
     * Constructor.
     * 
     * @param name the name. 
     */
    public MObject(String name) {
        this.methods = new ArrayList<>();
        this.name = name;
    }
    
    /**
     * Get the methods.
     * 
     * @return the methods.
     */
    public List<MMethod> getMethods() {
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
    public void setMethods(List<MMethod> methods) {
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
