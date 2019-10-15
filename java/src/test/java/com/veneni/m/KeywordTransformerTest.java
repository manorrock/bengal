/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * The JUnit tests for the AstKeywordTransformer class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class KeywordTransformerTest {
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        Object result = transformer.process('a');
        assertNotNull(result);
        assertEquals(result, 'a');
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess2() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        Object result = transformer.process("this_is_a_string");
        assertNotNull(result);
        assertEquals(result, "this_is_a_string");
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess3() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        transformer.process('o');
        transformer.process('b');
        transformer.process('j');
        transformer.process('e');
        transformer.process('c');
        Object result = transformer.process('t');
        assertNotNull(result);
        assertEquals(result, AstKeyword.OBJECT);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess4() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        transformer.process('m');
        transformer.process('e');
        transformer.process('t');
        transformer.process('h');
        transformer.process('o');
        Object result = transformer.process('d');
        assertNotNull(result);
        assertEquals(result, AstKeyword.METHOD);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess5() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        transformer.process('i');
        Object result = transformer.process('f');
        assertNotNull(result);
        assertEquals(result, AstKeyword.IF);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess6() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        transformer.process('t');
        transformer.process('h');
        transformer.process('e');
        Object result = transformer.process('n');
        assertNotNull(result);
        assertEquals(result, AstKeyword.THEN);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess7() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        transformer.process('e');
        transformer.process('l');
        transformer.process('s');
        Object result = transformer.process('e');
        assertNotNull(result);
        assertEquals(result, AstKeyword.ELSE);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess8() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        transformer.process('d');
        Object result = transformer.process('o');
        assertNotNull(result);
        assertEquals(result, AstKeyword.DO);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess9() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        transformer.process('w');
        transformer.process('h');
        transformer.process('i');
        transformer.process('l');
        Object result = transformer.process('e');
        assertNotNull(result);
        assertEquals(result, AstKeyword.WHILE);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess10() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        transformer.process('f');
        transformer.process('o');
        Object result = transformer.process('r');
        assertNotNull(result);
        assertEquals(AstKeyword.FOR, result);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess11() {
        AstKeywordTransformer transformer = new AstKeywordTransformer();
        transformer.process('n');
        transformer.process('a');
        transformer.process('t');
        transformer.process('i');
        transformer.process('v');
        Object result = transformer.process('e');
        assertNotNull(result);
        assertEquals(result, AstKeyword.NATIVE);
    }
}
