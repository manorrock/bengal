/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for the MKeywordTransformer class.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MKeywordTransformerTest {
    
    /**
     * Test run method.
     */
    @Test
    public void testRun() {
        MKeywordTransformer transformer = new MKeywordTransformer("if");
        ArrayList input = new ArrayList();
        input.add('i');
        input.add('f');
        List output = transformer.transform(input);
        assertEquals(new MKeyword("if"), output.get(0));
    }
        
    /**
     * Test run method.
     */
    @Test
    public void testRun2() {
        MKeywordTransformer transformer = new MKeywordTransformer("if");
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
        MKeywordTransformer transformer = new MKeywordTransformer("if");
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
        MKeywordTransformer transformer = new MKeywordTransformer("if");
        ArrayList input = new ArrayList();
        input.add('i');
        List output = transformer.transform(input);
        assertEquals('i', output.get(0));
    }
}
