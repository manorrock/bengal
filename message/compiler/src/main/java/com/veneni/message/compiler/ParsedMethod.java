/*
 * Copyright (c) 2002-2020 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.compiler;

/**
 * A parsed method.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
class ParsedMethod {
    
    /**
     * Stores the name.
     */
    private final String name;
    
    /**
     * Constructor.
     * 
     * @param name the name.
     */
    public ParsedMethod(String name) {
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
