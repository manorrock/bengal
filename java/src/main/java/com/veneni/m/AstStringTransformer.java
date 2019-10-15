/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A transformer that looks for strings and transforms them into AstString
 * instances.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstStringTransformer {

    /**
     * Stores the internal buffer.
     */
    private final StringBuilder buffer;

    /**
     * Constructor.
     */
    public AstStringTransformer() {
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
        if (object instanceof Character) {
            buffer.append(object);
            String string = buffer.toString();
            if (string.startsWith("\"") && string.endsWith("\"") && string.length() > 1) {
                string = buffer.toString().substring(1);
                string = string.substring(0, string.length() - 1);
                result = new AstString(string);
                buffer.setLength(0);
            }
        } else {
            result = object;
        }
        return result;
    }
}
