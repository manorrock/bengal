/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the AstCommentTransformer class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class AstCommentTransformerTest {

    /**
     * Test process method.
     */
    @Test
    public void testProcess() {
        AstCommentTransformer transformer = new AstCommentTransformer();
        transformer.process('/');
        transformer.process('*');
        transformer.process('*');
        Object result = transformer.process('/');
        assertTrue(result instanceof AstComment);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProces2() {
        AstCommentTransformer transformer = new AstCommentTransformer();
        Object result = transformer.process("this_is_a_string");
        assertTrue(result instanceof String);
        assertEquals("this_is_a_string", result);
    }
}
