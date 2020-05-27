/*
 * Copyright (c) 2002-2020 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.compiler;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the ParsedObject class.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class ParsedMethodTest {
    
    /**
     * Test compiling "method myMethod() {}".
     */
    @Test
    public void testCompilingObject() {
        String input = "method MyMethod() { }";
        Compiler compiler = new Compiler();
        String output = compiler.compile(input);
        assertTrue(output.contains("private Object"));
        assertTrue(output.contains("() {\n}"));
    }
}
