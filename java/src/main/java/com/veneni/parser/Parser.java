/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.parser;

import com.veneni.java.transformer.CharacterTransformer;
import com.veneni.java.transformer.CommentTransformer;
import com.veneni.java.transformer.StringTransformer;
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
        CharacterTransformer characterTransformer = new CharacterTransformer();
        result = characterTransformer.transform((List) result);
        StringTransformer stringTransformer = new StringTransformer();
        result = stringTransformer.transform((List) result);
        return result;
    }
}
