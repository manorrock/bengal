/*
 * Copyright (c) 2002-2020 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.compiler;

import com.veneni.message.compiler.VeneniMessageParser;
import com.veneni.message.runtime.VeneniMessageObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the Veneni Message parser.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class VeneniMessageParserTest {
    
    /**
     * Test parse method.
     */
    @Test
    public void testParse() {
        String string = "object MyObject { }";
        VeneniMessageParser parser = new VeneniMessageParser();
        Object result = parser.parse(string);
        assertTrue(result instanceof VeneniMessageObject);
        VeneniMessageObject object = (VeneniMessageObject) result;
        assertEquals("MyObject", object.getName());
    }
}
