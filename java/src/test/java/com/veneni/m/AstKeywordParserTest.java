/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The JUnit tests for the AstKeywordParser.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstKeywordParserTest {
    
    /**
     * Test parse method.
     */
    @Test
    public void testParse() {
        AstKeywordParser parser = new AstKeywordParser(AstKeyword.DO, "do");
        Object result = parser.parse("do");
        assertTrue(result instanceof AstKeyword);
        assertEquals(result, AstKeyword.DO);
        assertEquals(parser.parse("notdo"), "notdo");
    }
}
