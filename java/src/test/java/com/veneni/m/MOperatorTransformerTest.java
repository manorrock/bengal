/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the MOperatorTransformer class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MOperatorTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransformAssignment() {
        ArrayList input = new ArrayList();
        input.add('=');
        MOperatorTransformer transformer = new MOperatorTransformer(MOperator.ASSIGNMENT);
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof MOperator);
        assertEquals(output.get(0), MOperator.ASSIGNMENT);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransformDot() {
        ArrayList input = new ArrayList();
        input.add('.');
        MOperatorTransformer transformer = new MOperatorTransformer(MOperator.DOT);
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof MOperator);
        assertEquals(output.get(0), MOperator.DOT);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransformLeftCurly() {
        ArrayList input = new ArrayList();
        input.add('{');
        MOperatorTransformer transformer = new MOperatorTransformer(MOperator.LEFT_CURLY);
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof MOperator);
        assertEquals(output.get(0), MOperator.LEFT_CURLY);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransformLeftParenthesis() {
        ArrayList input = new ArrayList();
        input.add('(');
        MOperatorTransformer transformer = new MOperatorTransformer(MOperator.LEFT_PARENTHESIS);
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof MOperator);
        assertEquals(output.get(0), MOperator.LEFT_PARENTHESIS);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransformRightCurly() {
        ArrayList input = new ArrayList();
        input.add('}');
        MOperatorTransformer transformer = new MOperatorTransformer(MOperator.RIGHT_CURLY);
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof MOperator);
        assertEquals(output.get(0), MOperator.RIGHT_CURLY);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransformRightParenthesis() {
        ArrayList input = new ArrayList();
        input.add(')');
        MOperatorTransformer transformer = new MOperatorTransformer(MOperator.RIGHT_PARENTHESIS);
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof MOperator);
        assertEquals(output.get(0), MOperator.RIGHT_PARENTHESIS);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransformSemicolon() {
        ArrayList input = new ArrayList();
        input.add(';');
        MOperatorTransformer transformer = new MOperatorTransformer(MOperator.SEMICOLON);
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof MOperator);
        assertEquals(output.get(0), MOperator.SEMICOLON);
    }
}
