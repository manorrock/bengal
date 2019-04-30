/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * An operator in the Veneni-M language.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MOperator {

    /**
     * Defines the assignment operator "=".
     */
    public static final MOperator ASSIGNMENT = new MOperator("=");

    /**
     * Defines the dot operator ".".
     */
    public static final MOperator DOT = new MOperator(".");
    
    /**
     * Defines the left curly brace operator "{".
     */
    public static final MOperator LEFT_CURLY = new MOperator("{");

    /**
     * Define the left parenthesis operator "(".
     */
    public static final MOperator LEFT_PARENTHESIS = new MOperator("(");

    /**
     * Defines the right curly brace operator "}".
     */
    public static final MOperator RIGHT_CURLY = new MOperator("}");

    /**
     * Define the right parenthesis operator "(".
     */
    public static final MOperator RIGHT_PARENTHESIS = new MOperator(")");

    /**
     * Define the semicolon operator ";".
     */
    public static final MOperator SEMICOLON = new MOperator(";");

    /**
     * Stores the operator.
     */
    private final String operator;

    /**
     * Constructor.
     *
     * @param operator the operator.
     */
    public MOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Get the operator.
     *
     * @return the operator.
     */
    public String getOperator() {
        return operator;
    }
}
