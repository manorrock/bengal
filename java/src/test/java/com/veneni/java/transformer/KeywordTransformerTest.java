/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.transformer;

import com.veneni.java.Done;
import com.veneni.java.ast.AstKeyword;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
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
        ArrayList input = new ArrayList();
        input.add('i');
        input.add('f');
        List output = transformer.transform(input);
        assertEquals(new AstKeyword("if"), output.get(0));
    }
        
    /**
     * Test run method.
     */
    @Test
    public void testRun2() {
        KeywordTransformer transformer = new KeywordTransformer("if");
        ArrayList input = new ArrayList();
        input.add('n');
        input.add('o');
        input.add('t');
        List output = transformer.transform(input);
        assertEquals('n', output.get(0));
        assertEquals('o', output.get(1));
        assertEquals('t', output.get(2));
    }
    
    /**
     * Test run method.
     */
    @Test
    public void testRun3() {
        KeywordTransformer transformer = new KeywordTransformer("if");
        ArrayList input = new ArrayList();
        input.add("not recognized");
        List output = transformer.transform(input);
        assertEquals("not recognized", output.get(0));
    }
     
    /**
     * Test run method.
     */
    @Test
    public void testRun4() {
        KeywordTransformer transformer = new KeywordTransformer("if");
        ArrayList input = new ArrayList();
        input.add('i');
        List output = transformer.transform(input);
        assertEquals('i', output.get(0));
    }
}
