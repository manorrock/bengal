/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.message;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals(true, mb.getBoolean());
        assertEquals("true", mb.toJava());
    }
}
