/*
 * Copyright (c) 2002-2020 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the ParsedNil class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class ParsedNilTest {
    
    /**
     * Test compiling "nil" to "class0.INSTANCE".
     */
    @Test
    public void testCompilingNil() {
        String input = "nil";
        Compiler compiler = new Compiler();
        String output = compiler.compile(input);
        assertEquals("Object0.INSTANCE", output);
    }
}
