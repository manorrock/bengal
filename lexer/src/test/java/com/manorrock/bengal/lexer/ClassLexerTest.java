/*
 * Copyright (c) 2002-2024 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.lexer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The JUnit tests for the ClassLexer.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class ClassLexerTest {

    /**
     * Test process method.
     */
    @Test
    public void testProcess() {
        ClassLexer lexer = new ClassLexer();
        lexer.process('c');
        lexer.process('l');
        lexer.process('a');
        lexer.process('s');
        Token result = lexer.process('s');
        assertTrue(result instanceof ClassToken);
    }
}
