/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java;

import java.util.Deque;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The JUnit tests for the KeywordTransformer class.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class KeywordTransformerTest {
    
    /**
     * Test run method.
     */
    @Test
    public void testRun() {
        KeywordTransformer transformer = new KeywordTransformer("if");
        Deque input = transformer.getInput();
        input.addFirst('i');
        input.addFirst('f');
        input.addFirst(new Done());
        transformer.run();
        Deque output = transformer.getOutput();
        assertEquals(new Keyword("if"), output.getLast());
    }
        
    /**
     * Test run method.
     */
    @Test
    public void testRun2() {
        KeywordTransformer transformer = new KeywordTransformer("if");
        Deque input = transformer.getInput();
        input.addFirst('n');
        input.addFirst('o');
        input.addFirst('t');
        input.addFirst(new Done());
        transformer.run();
        Deque output = transformer.getOutput();
        assertEquals('n', output.pollLast());
        assertEquals('o', output.pollLast());
        assertEquals('t', output.pollLast());
    }
    
    /**
     * Test run method.
     */
    @Test
    public void testRun3() {
        KeywordTransformer transformer = new KeywordTransformer("if");
        Deque input = transformer.getInput();
        input.addFirst("not recognized");
        input.addFirst(new Done());
        transformer.run();
        Deque output = transformer.getOutput();
        assertEquals("not recognized", output.pollLast());
    }
}
