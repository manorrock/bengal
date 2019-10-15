/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the Parser class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class ParserTest {

    /**
     * Test parse method.
     */
    @Test
    public void testParse() {
        Parser parser = new Parser();
        Object result = parser.parse("do");
        assertTrue(result instanceof AstKeyword);
        assertEquals(AstKeyword.DO, result);
    }

    /**
     * Test parse method.
     */
    @Test
    public void testParse2() {
        Parser parser = new Parser();
        Object result = parser.parse("do {");
        assertTrue(result instanceof List);
        List list = (List) result;
        assertEquals(AstKeyword.DO, list.get(0));
        assertEquals(' ', list.get(1));
        assertEquals(AstOperator.LEFT_CURLY_BRACKET, list.get(2));
    }
    
    /**
     * Test parse method.
     */
    @Test
    public void testParseFile() {
        Parser parser = new Parser();
        Object result = parser.parseFile("src/test/veneni/Object.m");
        assertEquals(AstKeyword.OBJECT, result);
    }
    
    /**
     * Test parse method.
     */
    @Test
    public void testParseFile2() {
        Parser parser = new Parser();
        Object result = parser.parseFile("src/test/veneni/Method.m");
        assertEquals(AstKeyword.METHOD, result);
    }
}
