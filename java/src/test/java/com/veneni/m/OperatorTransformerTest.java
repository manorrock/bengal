/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * The JUnit tests for the OperatorTransformer class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class OperatorTransformerTest {

    /**
     * Test process method.
     */
    @Test
    public void testProcess() {
        OperatorTransformer transformer = new OperatorTransformer();
        Object result = transformer.process('(');
        assertNotNull(result);
        assertEquals(result, Operator.LEFT_PARENTHESIS);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess2() {
        OperatorTransformer transformer = new OperatorTransformer();
        Object result = transformer.process(')');
        assertNotNull(result);
        assertEquals(result, Operator.RIGHT_PARENTHESIS);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess3() {
        OperatorTransformer transformer = new OperatorTransformer();
        Object result = transformer.process(';');
        assertNotNull(result);
        assertEquals(result, Operator.SEMICOLON);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess4() {
        OperatorTransformer transformer = new OperatorTransformer();
        Object result = transformer.process('{');
        assertNotNull(result);
        assertEquals(result, Operator.LEFT_CURLY_BRACKET);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess5() {
        OperatorTransformer transformer = new OperatorTransformer();
        Object result = transformer.process('}');
        assertNotNull(result);
        assertEquals(result, Operator.RIGHT_CURLY_BRACKET);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess6() {
        OperatorTransformer transformer = new OperatorTransformer();
        Object result = transformer.process('.');
        assertNotNull(result);
        assertEquals(result, Operator.DOT);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess7() {
        OperatorTransformer transformer = new OperatorTransformer();
        Object result = transformer.process('=');
        assertNotNull(result);
        assertEquals(result, Operator.EQUALS);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess8() {
        OperatorTransformer transformer = new OperatorTransformer();
        Object result = transformer.process("this_is_a_string");
        assertNotNull(result);
        assertEquals(result, "this_is_a_string");
    }
}
