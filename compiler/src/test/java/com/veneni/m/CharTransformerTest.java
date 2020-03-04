/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the AstCharacterTransformer class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class CharTransformerTest {

    /**
     * Test process method.
     */
    @Test
    public void testProcess() {
        AstCharacterTransformer charTransformer = new AstCharacterTransformer();
        charTransformer.process('\'');
        charTransformer.process('a');
        Object result = charTransformer.process('\'');
        assertTrue(result instanceof AstCharacter);
    }

    /**
     * Test process method.
     */
    @Test
    public void testProces2() {
        AstCharacterTransformer charTransformer = new AstCharacterTransformer();
        Object result = charTransformer.process("this_is_a_string");
        assertTrue(result instanceof String);
        assertEquals("this_is_a_string", result);
    }
}
