/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.transformer;

import com.veneni.java.ast.AstKeyword;
import java.util.ArrayList;
import java.util.List;

/**
 * The keyword transformer.
 *
 * <p>
 * This transformer will take a specific keyword and transform it from its
 * characters to a AstKeyword object.
 * </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class KeywordTransformer extends BaseTransformer {

    /**
     * Stores the string builder.
     */
    private final StringBuilder stringBuilder;

    /**
     * Stores the keyword.
     */
    private final String keyword;

    /**
     * Constructor.
     *
     * @param keyword the keyword.
     */
    public KeywordTransformer(String keyword) {
        this.keyword = keyword;
        this.stringBuilder = new StringBuilder();
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
                stringBuilder.append(character.charValue());
                if (keyword.equals(stringBuilder.toString())) {
                    AstKeyword match = new AstKeyword(keyword);
                    stringBuilder.setLength(0);
                    result.add(match);
                } else if (!keyword.startsWith(stringBuilder.toString())) {
                    result.addAll(drainStringBuilderToList(stringBuilder));
                    stringBuilder.setLength(0);
                }
            } else {
                result.add(object);
            }
        });
        if (stringBuilder.length() > 0) {
            result.addAll(drainStringBuilderToList(stringBuilder));
        }
        return result;
    }
}
