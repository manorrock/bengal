/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import com.veneni.java.transformer.BaseTransformer;
import java.util.ArrayList;
import java.util.List;

/**
 * The operator transformer.
 *
 * <p>
 * This transformer will take a specific operator and transform it from its
 * characters to an MOperator object.
 * </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MOperatorTransformer extends BaseTransformer {

    /**
     * Stores the string builder.
     */
    private final StringBuilder stringBuilder;

    /**
     * Stores the operator.
     */
    private final MOperator operator;

    /**
     * Constructor.
     *
     * @param operator the operator.
     */
    public MOperatorTransformer(MOperator operator) {
        this.operator = operator;
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
                if (operator.getOperator().equals(stringBuilder.toString())) {
                    stringBuilder.setLength(0);
                    result.add(operator);
                } else if (!operator.getOperator().startsWith(stringBuilder.toString())) {
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
