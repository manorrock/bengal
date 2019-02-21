/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.transformer;

import com.veneni.java.ast.AstCharacter;
import java.util.ArrayList;
import java.util.List;

/**
 * The character transformer.
 *
 * <p>
 * This transformer will transform characters.
 * </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class CharacterTransformer extends BaseTransformer {

    /**
     * Stores the string builder.
     */
    private final StringBuilder stringBuilder;

    /**
     * Constructor.
     */
    public CharacterTransformer() {
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
                    AstCharacter astCharacter = new AstCharacter(
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
