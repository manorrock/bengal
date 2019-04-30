/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;

/**
 * The MCharacter transformer.
 *
 * <p>
 * This transformer will transform characters into MCharacter objects.
 * </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MCharacterTransformer extends BaseTransformer {

    /**
     * Stores the string builder.
     */
    private final StringBuilder stringBuilder;

    /**
     * Constructor.
     */
    public MCharacterTransformer() {
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
                char character = (Character) object;
                if (stringBuilder.length() > 0 && character != '\'') {
                    stringBuilder.append(character);
                } else if (stringBuilder.length() > 0 && character == '\'') {
                    MCharacter astCharacter = new MCharacter(
                            stringBuilder.toString().substring(1));
                    result.add(astCharacter);
                    stringBuilder.setLength(0);
                } else if (character == '\'') {
                    stringBuilder.append(character);
                } else {
                    result.add(character);
                }
            } else {
                if (stringBuilder.length() > 0) {
                    result.addAll(drainStringBuilderToList(stringBuilder));
                    stringBuilder.setLength(0);
                }
                result.add(object);
            }
        });
        if (stringBuilder.length() > 0) {
            result.addAll(drainStringBuilderToList(stringBuilder));
        }
        return result;
    }
}
