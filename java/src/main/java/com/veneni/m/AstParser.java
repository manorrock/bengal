/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * An AST parser.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public interface AstParser {

    /**
     * Parse.
     * 
     * @param input the input.
     * @return the output.
     */
    public Object parse(Object input);
}
