/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * The AST keyword parser.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class AstKeywordParser implements AstParser {

    /**
     * Stores the keyword.
     */
    private final AstKeyword keyword;
    
    /**
     * Stores the keyword in string format.
     */
    private final String keywordString;
    
    /**
     * Constructor.
     * 
     * @param keyword the keyword.
     * @param keywordString the keyword in string format.
     */
    public AstKeywordParser(AstKeyword keyword, String keywordString) {
        this.keyword = keyword;
        this.keywordString = keywordString;
    }

    /**
     * Parse.
     *
     * @param input the input.
     * @return the result.
     */
    @Override
    public Object parse(Object input) {
        Object result = input;
        if (input instanceof String) {
            String inputString = (String) input;
            if (inputString.equals(keywordString)) {
                result = keyword;
            }
        }
        return result;
    }
}
