/*
 * Copyright (c) 2002-2020 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the ParsedBoolean class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class ParsedBooleanTest {
    
    /**
     * Test compiling "true" to "true".
     */
    @Test
    public void testCompilingTrue() {
        String input = "true";
        Compiler compiler = new Compiler();
        String output = compiler.compile(input);
        assertEquals("true", output);
    }
    
    /**
     * Test compiling "false" to "false".
     */
    @Test
    public void testCompilingFalse() {
        String input = "false";
        Compiler compiler = new Compiler();
        String output = compiler.compile(input);
        assertEquals("false", output);
    }
}
