/*
 * Copyright (c) 2002-2024 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.lexer;

import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the Lexer class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class LexerTest {

    /**
     * Test run method.
     */
    @Test
    public void testRun() {
        Lexer lexer = new Lexer();
        lexer.setArguments(new String[]{"src/test/bengal/test.b0", "target/lexer/test.bl0"});
        lexer.run();
        assertTrue(new File("target/lexer/test.bl0").exists());
    }
}
