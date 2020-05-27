/*
 * Copyright (c) 2002-2020 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.compiler;

/**
 * A parsed boolean.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
class ParsedBoolean {
    
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
}
