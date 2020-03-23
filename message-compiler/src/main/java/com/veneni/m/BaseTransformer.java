/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;

/**
 * The base transformer class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
class BaseTransformer {

    /**
     * Utility method to drain a StringBuilder back into a list.
     *
     * @param stringBuilder the string builder to drain.
     * @return the list.
     */
    protected List drainStringBuilderToList(StringBuilder stringBuilder) {
        ArrayList result = new ArrayList();
        if (stringBuilder.length() > 0) {
            for (int i = 0; i < stringBuilder.length(); i++) {
                result.add(stringBuilder.charAt(i));
            }
        }
        return result;
    }
}
