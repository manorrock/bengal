/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;

/**
 * The MComment transformer.
 *
 * <p>
 * This transformer will transform characters into MComment objects.
 * </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MCommentTransformer extends BaseTransformer {

    /**
     * Stores the string builder.
     */
    private final StringBuilder stringBuilder = new StringBuilder();

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
                if (stringBuilder.length() == 0 && character == '/') {
                    stringBuilder.append(character);
                } else if (stringBuilder.length() == 1 && character == '*') {
                    stringBuilder.append(character);
                } else if (stringBuilder.length() > 1) {
                    stringBuilder.append(character);
                } else {
                    result.addAll(drainStringBuilderToList(stringBuilder));
                    result.add(object);
                }
                if (stringBuilder.length() > 0 && stringBuilder.toString().endsWith("*/")) {
                    result.add(new MComment(stringBuilder.substring(2, stringBuilder.length() - 2)));
                    stringBuilder.setLength(0);
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
