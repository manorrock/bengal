/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.transformer;

import com.veneni.java.ast.AstString;
import java.util.ArrayList;
import java.util.List;

/**
 * The string transformer.
 *
 * <p>
 * This transformer will transform strings into AstStrings.
 * </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class StringTransformer extends BaseTransformer {

    /**
     * Stores the string builder.
     */
    private final StringBuilder stringBuilder;

    /**
     * Constructor.
     */
    public StringTransformer() {
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
        for (Object object : input) {
            if (object instanceof Character) {
                Character character = (Character) object;
                if (stringBuilder.length() == 0 && character == '"') {
                    stringBuilder.append(character);
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(character);
                } else {
                    result.addAll(drainStringBuilderToList(stringBuilder));
                    result.add(object);
                }
                if (stringBuilder.length() > 1 && stringBuilder.toString().endsWith("\"")) {
                    result.add(new AstString(stringBuilder.toString()));
                }
            } else {
                result.addAll(drainStringBuilderToList(stringBuilder));
                result.add(object);
            }
        }
        result.addAll(drainStringBuilderToList(stringBuilder));
        return result;
    }
}
