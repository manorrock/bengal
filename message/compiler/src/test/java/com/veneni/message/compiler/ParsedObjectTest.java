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
public class ParsedObjectTest {
    
    /**
     * Test compiling "object MyObject".
     */
    @Test
    public void testCompilingObject() {
        String input = "object MyObject { }";
        Compiler compiler = new Compiler();
        String output = compiler.compile(input);
        assertTrue(output.contains("public class class"));
        assertTrue(output.contains("VENENI_OBJECT_NAME = \"MyObject\""));
    }
}
