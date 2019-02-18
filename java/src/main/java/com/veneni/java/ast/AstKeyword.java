/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.ast;

import java.util.Objects;

/**
 * A keyword.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstKeyword {
    
    /**
     * Stores the keyword.
     */
    private final String keyword;

    /**
     * Constructor.
     * 
     * @param keyword the keyword.
     */
    public AstKeyword(String keyword) {
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
        if (object instanceof AstKeyword) {
            AstKeyword candidate = (AstKeyword) object;
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
