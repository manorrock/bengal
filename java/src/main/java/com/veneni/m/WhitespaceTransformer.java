/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Transformer that looks for Char instances and transforms them into
 * Whitespace instances.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class WhitespaceTransformer implements Transformer {

    /**
     * Transform.
     *
     * @param input the object.
     * @return the output.
     */
    @Override
    public Object transform(Object input) {
        Object result = input;
        if (input instanceof List) {
            List list = (List) input;
            ArrayList parsed = new ArrayList();
            Iterator iterator = list.iterator();
            Object previous = null;
            Object current;
            while (iterator.hasNext()) {
                Object object = iterator.next();
                if (object instanceof Char) {
                    Char character = (Char) object;
                    if (Character.isWhitespace(character.toChar())) {
                        current = new Whitespace(character.toString());
                    } else {
                        current = object;
                    }
                } else {
                    current = object;
                }
                if (previous == null) {
                    previous = current;
                } else {
                    if (previous instanceof Whitespace && current instanceof Whitespace) {
                        previous = new Whitespace(previous.toString() + current.toString());
                    } else {
                        parsed.add(previous);
                        previous = current;
                    }
                }
            }
            if (previous != null) {
                parsed.add(previous);
            }
            result = parsed;
        }
        return result;
    }
}
