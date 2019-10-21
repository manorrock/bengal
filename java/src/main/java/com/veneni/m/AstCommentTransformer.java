/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A transformer that looks for characters and transforms them into AstComment
 * instances.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstCommentTransformer {

    /**
     * Stores the internal buffer.
     */
    private final StringBuilder buffer;

    /**
     * Constructor.
     */
    public AstCommentTransformer() {
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
            if (string.startsWith("/*") && string.endsWith("*/") && string.length() >= 4) {
                string = buffer.toString().substring(2);
                string = string.substring(0, string.length() - 2);
                result = new AstComment(string);
                buffer.setLength(0);
            }
        } else {
            result = object;
        }
        return result;
    }
}
