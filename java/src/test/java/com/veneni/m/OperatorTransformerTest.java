/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;
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
        ArrayList input = new ArrayList();
        input.add(new Char('('));
        List result = (List) transformer.process(input);
        assertNotNull(result);
        assertEquals(Operator.LEFT_PARENTHESIS, result.get(0));
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess2() {
        OperatorTransformer transformer = new OperatorTransformer();
        ArrayList input = new ArrayList();
        input.add(new Char(')'));
        List result = (List) transformer.process(input);
        assertNotNull(result);
        assertEquals(Operator.RIGHT_PARENTHESIS, result.get(0));
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess3() {
        OperatorTransformer transformer = new OperatorTransformer();
        ArrayList input = new ArrayList();
        input.add(new Char(';'));
        List result = (List) transformer.process(input);
        assertNotNull(result);
        assertEquals(Operator.SEMICOLON, result.get(0));
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess4() {
        OperatorTransformer transformer = new OperatorTransformer();
        ArrayList input = new ArrayList();
        input.add(new Char('{'));
        List result = (List) transformer.process(input);
        assertNotNull(result);
        assertEquals(Operator.LEFT_CURLY_BRACKET, result.get(0));
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess5() {
        OperatorTransformer transformer = new OperatorTransformer();
        ArrayList input = new ArrayList();
        input.add(new Char('}'));
        List result = (List) transformer.process(input);
        assertNotNull(result);
        assertEquals(Operator.RIGHT_CURLY_BRACKET, result.get(0));
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess6() {
        OperatorTransformer transformer = new OperatorTransformer();
        ArrayList input = new ArrayList();
        input.add(new Char('.'));
        List result = (List) transformer.process(input);
        assertNotNull(result);
        assertEquals(Operator.DOT, result.get(0));
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess7() {
        OperatorTransformer transformer = new OperatorTransformer();
        ArrayList input = new ArrayList();
        input.add(new Char('='));
        List result = (List) transformer.process(input);
        assertNotNull(result);
        assertEquals(Operator.EQUALS, result.get(0));
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess8() {
        OperatorTransformer transformer = new OperatorTransformer();
        Object result = transformer.process("this_is_a_string");
        assertNotNull(result);
        assertEquals("this_is_a_string", result);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProcess9() {
        OperatorTransformer transformer = new OperatorTransformer();
        ArrayList input = new ArrayList();
        input.add(new Char('a'));
        List result = (List) transformer.process(input);
        assertNotNull(result);
        assertEquals(new Char('a'), result.get(0));
    }
}
