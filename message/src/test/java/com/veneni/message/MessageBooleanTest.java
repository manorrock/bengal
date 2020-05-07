/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the MessageBoolean class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MessageBooleanTest {
    
    /**
     * Test translation "true" to "true".
     */
    @Test
    public void testTranslatingTrue() {
        String string = "true";
        VeneniMessageParser parser = new VeneniMessageParser();
        Object result = parser.parse(string);
        assertTrue(result instanceof MessageBoolean);
        MessageBoolean mb = (MessageBoolean) result;
        assertTrue(mb.getBoolean());
        assertEquals("true", mb.toJava());
    }
    
    /**
     * Test translation "false" to "false".
     */
    @Test
    public void testTranslatingFalse() {
        String string = "false";
        VeneniMessageParser parser = new VeneniMessageParser();
        Object result = parser.parse(string);
        assertTrue(result instanceof MessageBoolean);
        MessageBoolean mb = (MessageBoolean) result;
        assertFalse(mb.getBoolean());
        assertEquals("false", mb.toJava());
    }
}
