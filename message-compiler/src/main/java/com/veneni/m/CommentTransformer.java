/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Transformer that looks for Char instances and transforms them into
 * Comment instances.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class CommentTransformer implements Transformer {

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
            Iterator iterator = list.iterator();
            StringBuilder buffer = new StringBuilder();
            ArrayList<Char> characters = new ArrayList<>();
            ArrayList parsed = new ArrayList<>();
            while (iterator.hasNext()) {
                Object next = iterator.next();
                if (next instanceof Char) {
                    Char character = (Char) next;
                    characters.add(character);
                    buffer.append(character.toString());
                    String string = buffer.toString();
                    if (string.startsWith("/*") && string.endsWith("*/") && string.length() >= 4) {
                        string = buffer.toString().substring(2);
                        string = string.substring(0, string.length() - 2);
                        characters = new ArrayList<>();
                        parsed.add(new Comment(string));
                        buffer.setLength(0);
                    } else if (!string.startsWith("/")) {
                        parsed.addAll(characters);
                        characters = new ArrayList<>();
                        buffer.setLength(0);
                    }
                } else {
                    parsed.addAll(characters);
                    characters = new ArrayList<>();
                    buffer.setLength(0);
                    parsed.add(next);
                }
            }
            if (!characters.isEmpty()) {
                parsed.addAll(characters);
            }
            result = parsed;
        }
        return result;
    }
}
