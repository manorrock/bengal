/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * The JUnit tests for the KeywordTransformer class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class KeywordTransformerTest {
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess() {
        KeywordTransformer transformer = new KeywordTransformer();
        Object result = transformer.process('a');
        assertNotNull(result);
        assertEquals(result, 'a');
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess2() {
        KeywordTransformer transformer = new KeywordTransformer();
        Object result = transformer.process("this_is_a_string");
        assertNotNull(result);
        assertEquals(result, "this_is_a_string");
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess3() {
        KeywordTransformer transformer = new KeywordTransformer();
        transformer.process('o');
        transformer.process('b');
        transformer.process('j');
        transformer.process('e');
        transformer.process('c');
        Object result = transformer.process('t');
        assertNotNull(result);
        assertEquals(result, Keyword.OBJECT);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess4() {
        KeywordTransformer transformer = new KeywordTransformer();
        transformer.process('m');
        transformer.process('e');
        transformer.process('t');
        transformer.process('h');
        transformer.process('o');
        Object result = transformer.process('d');
        assertNotNull(result);
        assertEquals(result, Keyword.METHOD);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess5() {
        KeywordTransformer transformer = new KeywordTransformer();
        transformer.process('i');
        Object result = transformer.process('f');
        assertNotNull(result);
        assertEquals(result, Keyword.IF);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess6() {
        KeywordTransformer transformer = new KeywordTransformer();
        transformer.process('t');
        transformer.process('h');
        transformer.process('e');
        Object result = transformer.process('n');
        assertNotNull(result);
        assertEquals(result, Keyword.THEN);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess7() {
        KeywordTransformer transformer = new KeywordTransformer();
        transformer.process('e');
        transformer.process('l');
        transformer.process('s');
        Object result = transformer.process('e');
        assertNotNull(result);
        assertEquals(result, Keyword.ELSE);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess8() {
        KeywordTransformer transformer = new KeywordTransformer();
        transformer.process('d');
        Object result = transformer.process('o');
        assertNotNull(result);
        assertEquals(result, Keyword.DO);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess9() {
        KeywordTransformer transformer = new KeywordTransformer();
        transformer.process('w');
        transformer.process('h');
        transformer.process('i');
        transformer.process('l');
        Object result = transformer.process('e');
        assertNotNull(result);
        assertEquals(result, Keyword.WHILE);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess10() {
        KeywordTransformer transformer = new KeywordTransformer();
        transformer.process('f');
        transformer.process('o');
        Object result = transformer.process('r');
        assertNotNull(result);
        assertEquals(Keyword.FOR, result);
    }
    
    /**
     * Test process method.
     */
    @Test
    public void testProcess11() {
        KeywordTransformer transformer = new KeywordTransformer();
        transformer.process('n');
        transformer.process('a');
        transformer.process('t');
        transformer.process('i');
        transformer.process('v');
        Object result = transformer.process('e');
        assertNotNull(result);
        assertEquals(result, Keyword.NATIVE);
    }
}
