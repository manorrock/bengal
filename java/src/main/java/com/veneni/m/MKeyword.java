/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.Objects;

/**
 * A keyword in the Veneni-M language.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MKeyword {

    /**
     * Defines the keyword "do".
     */
    public static final MKeyword DO_KEYWORD = new MKeyword("do");

    /**
     * Defines the keyword "else".
     */
    public static final MKeyword ELSE_KEYWORD = new MKeyword("else");
    
    /**
     * Defines the keyword "false".
     */
    public static final MKeyword FALSE_KEYWORD = new MKeyword("false");
    
    /**
     * Defines the keyword "for".
     */
    public static final MKeyword FOR_KEYWORD = new MKeyword("for");

    /**
     * Defines the keyword "if".
     */
    public static final MKeyword IF_KEYWORD = new MKeyword("if");

    /**
     * Defines the keyword "nil".
     */
    public static final MKeyword NIL_KEYWORD = new MKeyword("nil");

    /**
     * Defines the keyword "then".
     */
    public static final MKeyword THEN_KEYWORD = new MKeyword("then");

    /**
     * Defines the keyword "true".
     */
    public static final MKeyword TRUE_KEYWORD = new MKeyword("true");

    /**
     * Defines the keyword "while".
     */
    public static final MKeyword WHILE_KEYWORD = new MKeyword("while");

    /**
     * Stores the keyword.
     */
    private final String keyword;

    /**
     * Constructor.
     *
     * @param keyword the keyword.
     */
    public MKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Equals.
     *
     * @param object
     * @return true if the keywords are equal.
     */
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object instanceof MKeyword) {
            MKeyword candidate = (MKeyword) object;
            if (candidate.keyword.equals(keyword)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Hash code.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(keyword);
        return hash;
    }
}
