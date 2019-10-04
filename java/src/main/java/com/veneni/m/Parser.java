/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * The parser.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Parser {

    /**
     * Parse the input.
     *
     * @param input the input.
     * @return the output.
     */
    public Object parse(String input) {
        if (input.equals("object")) {
            return Keyword.OBJECT;
        }
        return input;
    }
}
