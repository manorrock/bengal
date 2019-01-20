/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java;

import java.util.Deque;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The JUnit tests for the WhitespaceTransformer.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class WhitespaceTransformerTest {

    /**
     * Test run method.
     */
    @Test
    public void testRun() {
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        Deque input = transformer.getInput();
        input.addFirst(' ');
        input.addFirst(new Done());
        transformer.run();
        Deque output = transformer.getOutput();
        assertTrue(output.getLast() instanceof Whitespace);
    }

    /**
     * Test run method.
     */
    @Test
    public void testRun2() {
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        Deque input = transformer.getInput();
        input.addFirst(" ");
        input.addFirst(new Done());
        transformer.run();
        Deque output = transformer.getOutput();
        assertTrue(output.getLast() instanceof String);
    }

    /**
     * Test run method.
     */
    @Test
    public void testRun3() {
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        Deque input = transformer.getInput();
        input.addFirst('a');
        input.addFirst(new Done());
        transformer.run();
        Deque output = transformer.getOutput();
        assertTrue(output.getLast() instanceof Character);
    }

    /**
     * Test run method.
     */
    @Test
    public void testRun4() {
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        Deque input = transformer.getInput();
        input.addFirst(' ');
        input.addFirst(' ');
        input.addFirst('a');
        input.addFirst(new Done());
        transformer.run();
        Deque output = transformer.getOutput();
        assertTrue(output.pollLast() instanceof Whitespace);
        assertTrue(output.pollLast() instanceof Character);
        assertTrue(output.pollLast() instanceof Done);
    }
}
