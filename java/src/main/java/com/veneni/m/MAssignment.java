/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * An assignment in the Veneni-M language..
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MAssignment {
    
    /**
     * Stores the expression.
     */
    private Object expression;
    
    /**
     * Stores the variable (identifier).
     */
    private MIdentifier variable;
    
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
    public MIdentifier getVariable() {
        return variable;
    }
}
