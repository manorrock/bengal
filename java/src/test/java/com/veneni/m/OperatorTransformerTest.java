/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * The JUnit tests for the AstOperatorTransformer class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class OperatorTransformerTest {

    /**
     * Test process method.
     */
    @Test
    public void testProcess() {
        AstOperatorTransformer transformer = new AstOperatorTransformer();
        Object result = transformer.process('(');
        assertNotNull(result);
        assertEquals(result, AstOperator.LEFT_PARENTHESIS);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess2() {
        AstOperatorTransformer transformer = new AstOperatorTransformer();
        Object result = transformer.process(')');
        assertNotNull(result);
        assertEquals(result, AstOperator.RIGHT_PARENTHESIS);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess3() {
        AstOperatorTransformer transformer = new AstOperatorTransformer();
        Object result = transformer.process(';');
        assertNotNull(result);
        assertEquals(result, AstOperator.SEMICOLON);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess4() {
        AstOperatorTransformer transformer = new AstOperatorTransformer();
        Object result = transformer.process('{');
        assertNotNull(result);
        assertEquals(result, AstOperator.LEFT_CURLY_BRACKET);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess5() {
        AstOperatorTransformer transformer = new AstOperatorTransformer();
        Object result = transformer.process('}');
        assertNotNull(result);
        assertEquals(result, AstOperator.RIGHT_CURLY_BRACKET);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess6() {
        AstOperatorTransformer transformer = new AstOperatorTransformer();
        Object result = transformer.process('.');
        assertNotNull(result);
        assertEquals(result, AstOperator.DOT);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess7() {
        AstOperatorTransformer transformer = new AstOperatorTransformer();
        Object result = transformer.process('=');
        assertNotNull(result);
        assertEquals(result, AstOperator.EQUALS);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess8() {
        AstOperatorTransformer transformer = new AstOperatorTransformer();
        Object result = transformer.process("this_is_a_string");
        assertNotNull(result);
        assertEquals(result, "this_is_a_string");
    }
}
