/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;

/**
 * The MWhitespace transformer.
 *
 * <p>
 * This transformer will take whitespace characters and transform them into
 * MWhitespace objects.
 * </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MWhitespaceTransformer {

    /**
     * Stores the string builder.
     */
    private final StringBuilder stringBuilder;

    /**
     * Constructor.
     */
    public MWhitespaceTransformer() {
        stringBuilder = new StringBuilder();
    }

    /**
     * Transform.
     *
     * @param input the input.
     * @return the output.
     */
    public List transform(List input) {
        ArrayList result = new ArrayList();
        input.forEach((object) -> {
            if (object instanceof java.lang.Character) {
                java.lang.Character character = (java.lang.Character) object;
                if (!java.lang.Character.isWhitespace(character)) {
                    result.add(character);
                } else {
                    if (stringBuilder.length() > 0) {
                        MWhitespace whitespace = new MWhitespace(stringBuilder.toString());
                        result.add(whitespace);
                        stringBuilder.setLength(0);
                    } else {
                        stringBuilder.append(character);
                    }
                }
            } else {
                result.add(object);
            }
        });
        if (stringBuilder.length() > 0) {
            MWhitespace whitespace = new MWhitespace(stringBuilder.toString());
            result.add(whitespace);
        }
        return result;
    }
}
