/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static com.veneni.m.Operator.DOT;
import static com.veneni.m.Operator.EQUALS;
import static com.veneni.m.Operator.LEFT_CURLY_BRACKET;
import static com.veneni.m.Operator.LEFT_PARENTHESIS;
import static com.veneni.m.Operator.RIGHT_CURLY_BRACKET;
import static com.veneni.m.Operator.RIGHT_PARENTHESIS;
import static com.veneni.m.Operator.SEMICOLON;

/**
 * A transformer that looks for operators and transforms them into Operator
 * instances.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class OperatorTransformer {

    /**
     * Stores the array of operator enum values.
     */
    private final Operator[] enums = {
        LEFT_PARENTHESIS,
        RIGHT_PARENTHESIS,
        SEMICOLON,
        LEFT_CURLY_BRACKET,
        RIGHT_CURLY_BRACKET,
        DOT,
        EQUALS
    };

    /**
     * Stores the array of operators.
     */
    private final Character[] operators = {
        '(',
        ')',
        ';',
        '{',
        '}',
        '.',
        '='
    };

    /**
     * Constructor.
     */
    public OperatorTransformer() {
    }

    /**
     * Process object.
     *
     * @param object the object.
     * @return the response, or null if none yet.
     */
    public Object process(Object object) {
        Object result = null;
        if (object instanceof Character) {
            boolean foundMatch = false;
            for (int i = 0; i < operators.length; i++) {
                Character operator = (Character) object;
                if (operator.equals(operators[i])) {
                    result = enums[i];
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                result = object;
            }
        } else {
            result = object;
        }
        return result;
    }
}
