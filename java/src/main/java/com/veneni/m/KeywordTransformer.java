/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A transformer that looks for keywords and transforms them into Keyword
 * instances.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class KeywordTransformer {

    /**
     * Stores the array of keywords.
     */
    private final String[] keywords = {
        "do",
        "else",
        "false",
        "for",
        "if",
        "method",
        "native",
        "nil",
        "object",
        "then",
        "true",
        "while"
    };

    /**
     * Constructor.
     */
    public KeywordTransformer() {
    }

    /**
     * Process input.
     *
     * @param input the input.
     * @return the output.
     */
    public Object transform(Object input) {
        Object result = input;
        if (input instanceof List) {
            List list = (List) input;
            Iterator iterator = list.iterator();
            ArrayList characterList = new ArrayList();
            StringBuilder characterBuffer = new StringBuilder();
            ArrayList resultList = new ArrayList();
            while (iterator.hasNext()) {
                Object object = iterator.next();
                if (object instanceof Char) {
                    characterList.add(object);
                    characterBuffer.append(object.toString());
                    boolean partialMatch = false;
                    boolean foundMatch = false;
                    for (String keyword : keywords) {
                        if (keyword.startsWith(characterBuffer.toString())) {
                            partialMatch = true;
                            break;
                        }
                    }
                    if (partialMatch) {
                        for (String keyword : keywords) {
                            if (characterBuffer.toString().equals(keyword)) {
                                foundMatch = true;
                                break;
                            }
                        }
                    }
                    if (foundMatch) {
                        resultList.add(Keyword.valueOf(characterBuffer.toString().toUpperCase()));
                        characterBuffer.setLength(0);
                    } else if (!partialMatch) {
                        resultList.addAll(characterList);
                        characterBuffer.setLength(0);
                    }
                } else {
                    resultList.addAll(characterList);
                    resultList.add(object);
                    characterList.clear();
                    characterBuffer.setLength(0);
                }
            }
            result = resultList;
        }
        return result;
    }
}
