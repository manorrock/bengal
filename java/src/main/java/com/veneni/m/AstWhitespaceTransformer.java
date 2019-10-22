/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A transformer that looks for characters and transforms them into AstWhitespace
 * instances.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstWhitespaceTransformer {

    /**
     * Process object.
     *
     * @param object the object.
     * @return the response, or null if none yet.
     */
    public Object process(Object object) {
        Object result;
        if (object instanceof Character && Character.isWhitespace(object.toString().charAt(0))) {
            result = new AstWhitespace(object.toString());
        } else {
            result = object;
        }
        return result;
    }
}
