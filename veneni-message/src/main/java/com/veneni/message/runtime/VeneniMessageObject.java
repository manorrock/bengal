/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.runtime;

/**
 * A Veneni Message object.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class VeneniMessageObject {
    
    /**
     * Stores the name.
     */
    private final String name;
    
    /**
     * Constructor.
     * 
     * @param name the name.
     */
    public VeneniMessageObject(String name) {
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
