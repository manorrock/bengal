/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * The Transformer API.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public interface Transformer {

    /**
     * Transform the input object.
     * 
     * @param input the input.
     * @return the output.
     */
    public Object transform(Object input);
}
