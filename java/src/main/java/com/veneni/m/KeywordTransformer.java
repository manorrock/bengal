/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static com.veneni.m.Keyword.DO;
import static com.veneni.m.Keyword.ELSE;
import static com.veneni.m.Keyword.FALSE;
import static com.veneni.m.Keyword.FOR;
import static com.veneni.m.Keyword.IF;
import static com.veneni.m.Keyword.METHOD;
import static com.veneni.m.Keyword.NATIVE;
import static com.veneni.m.Keyword.NIL;
import static com.veneni.m.Keyword.OBJECT;
import static com.veneni.m.Keyword.THEN;
import static com.veneni.m.Keyword.TRUE;
import static com.veneni.m.Keyword.WHILE;

/**
 * A transformer that looks for keywords and transforms them into Keyword
 * instances.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class KeywordTransformer {

    /**
     * Stores the array of keyword enum values.
     */
    private final Keyword[] enums = {
        OBJECT,
        METHOD,
        IF,
        THEN,
        ELSE,
        DO,
        WHILE,
        FOR,
        NATIVE,
        TRUE,
        FALSE,
        NIL
    };

    /**
     * Stores the array of keywords.
     */
    private final String[] keywords = {
        "object",
        "method",
        "if",
        "then",
        "else",
        "do",
        "while",
        "for",
        "native",
        "true",
        "false",
        "nil"
    };

    /**
     * Stores the internal buffer.
     */
    private final StringBuilder buffer;

    /**
     * Constructor.
     */
    public KeywordTransformer() {
        this.buffer = new StringBuilder();
    }

    /**
     * Process object.
     *
     * @param object the object.
     * @return the response, or null if none yet.
     */
    public Object process(Object object) {
        Object result = null;
        boolean startsWith = false;
        if (object instanceof Character) {
            buffer.append(object);
            for (int i = 0; i < keywords.length; i++) {
                String keyword = buffer.toString();
                if (keyword.equals(keywords[i])) {
                    buffer.setLength(0);
                    result = enums[i];
                    break;
                } else if (keywords[i].startsWith(keyword)) {
                    startsWith = true;
                }
            }
            if (result == null && !startsWith) {
                buffer.setLength(0);
                result = object;
            }
        } else {
            result = object;
        }
        return result;
    }
}
