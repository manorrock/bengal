/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.parser;

import com.veneni.java.transformer.CommentTransformer;
import java.util.List;

/**
 * The Parser.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Parser {

    /**
     * Parse.
     * 
     * @param input the input list.
     * @return the output.
     */
    public Object parse(List<Object> input) {
        Object result;
        CommentTransformer commentTransformer = new CommentTransformer();
        result = commentTransformer.transform(input);
        return result;
    }
}
