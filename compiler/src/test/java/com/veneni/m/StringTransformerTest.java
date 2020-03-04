/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the AstStringTransformer class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class StringTransformerTest {

    /**
     * Test process method.
     */
    @Test
    public void testProcess() {
        AstStringTransformer transformer = new AstStringTransformer();
        transformer.process('\"');
        transformer.process('a');
        Object result = transformer.process('\"');
        assertTrue(result instanceof AstString);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProces2() {
        AstStringTransformer transformer = new AstStringTransformer();
        Object result = transformer.process("this_is_a_string");
        assertTrue(result instanceof String);
        assertEquals("this_is_a_string", result);
    }
}
