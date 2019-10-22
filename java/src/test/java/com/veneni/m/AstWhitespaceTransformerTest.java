/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the AstWhitespaceTransformer class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class AstWhitespaceTransformerTest {

    /**
     * Test process method.
     */
    @Test
    public void testProcess() {
        AstWhitespaceTransformer transformer = new AstWhitespaceTransformer();
        Object result = transformer.process(' ');
        assertTrue(result instanceof AstWhitespace);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProces2() {
        AstWhitespaceTransformer transformer = new AstWhitespaceTransformer();
        Object result = transformer.process("this_is_a_string");
        assertTrue(result instanceof String);
        assertEquals("this_is_a_string", result);
    }
}
