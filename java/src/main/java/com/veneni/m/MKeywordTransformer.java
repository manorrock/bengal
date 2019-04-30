/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;

/**
 * The MKeyword transformer.
 *
 * <p>
 *  This transformer will take characters to MKeyword objects.
 * </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MKeywordTransformer extends BaseTransformer {

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
    public MKeywordTransformer(String keyword) {
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
                    MKeyword match = new MKeyword(keyword);
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
