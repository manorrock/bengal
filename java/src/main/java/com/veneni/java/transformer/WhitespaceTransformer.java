/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.transformer;

import com.veneni.java.ast.AstWhitespace;
import java.util.ArrayList;
import java.util.List;

/**
 * The whitespace transformer.
 *
 * <p>
 This transformer will take whitespace and transform it into AstWhitespace
 objects.
 </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class WhitespaceTransformer {

    /**
     * Stores the string builder.
     */
    private final StringBuilder stringBuilder;

    /**
     * Constructor.
     */
    public WhitespaceTransformer() {
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
            if (object instanceof Character) {
                Character character = (Character) object;
                if (!Character.isWhitespace(character)) {
                    result.add(character);
                } else {
                    if (stringBuilder.length() > 0) {
                        AstWhitespace whitespace = new AstWhitespace(stringBuilder.toString());
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
            AstWhitespace whitespace = new AstWhitespace(stringBuilder.toString());
            result.add(whitespace);
        }
        return result;
    }
}
