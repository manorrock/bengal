/*
 * Copyright (c) 2002-2024 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.lexer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The JUnit tests for the DotLexer.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class DotLexerTest {

    /**
     * Test process method.
     */
    @Test
    public void testProcess() {
        DotLexer lexer = new DotLexer();
        Token result = lexer.process('.');
        assertTrue(result instanceof Dot);
        result = lexer.process('A');
        assertNull(result);
    }
}
