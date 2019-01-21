/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java;

/**
 * An assignment.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Assignment {
    
    /**
     * Stores the expression.
     */
    private Object expression;
    
    /**
     * Stores the variable (identifier).
     */
    private Identifier variable;
    
    /**
     * Get the expression.
     * 
     * @return the expression.
     */
    public Object getExpression() {
        return expression;
    }
    
    /**
     * Get the variable.
     * 
     * @return the variable.
     */
    public Identifier getVariable() {
        return variable;
    }
}
