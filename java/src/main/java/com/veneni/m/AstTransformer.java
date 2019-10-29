/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * The AST transformer API.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public interface AstTransformer {

    /**
     * Receive the input object.
     * 
     * @param input the input.
     */
    public void receive(Object input);
}
