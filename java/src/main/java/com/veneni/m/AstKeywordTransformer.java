/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static com.veneni.m.AstKeyword.DO;
import static com.veneni.m.AstKeyword.ELSE;
import static com.veneni.m.AstKeyword.FALSE;
import static com.veneni.m.AstKeyword.FOR;
import static com.veneni.m.AstKeyword.IF;
import static com.veneni.m.AstKeyword.METHOD;
import static com.veneni.m.AstKeyword.NATIVE;
import static com.veneni.m.AstKeyword.NIL;
import static com.veneni.m.AstKeyword.OBJECT;
import static com.veneni.m.AstKeyword.THEN;
import static com.veneni.m.AstKeyword.TRUE;
import static com.veneni.m.AstKeyword.WHILE;

/**
 * A transformer that looks for keywords and transforms them into AstKeyword
 * instances.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstKeywordTransformer {

    /**
     * Stores the array of keyword enum values.
     */
    private final AstKeyword[] enums = {
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
    public AstKeywordTransformer() {
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
