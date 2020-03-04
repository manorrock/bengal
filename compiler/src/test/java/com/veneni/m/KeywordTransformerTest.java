/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the KeywordTransformer class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class KeywordTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        KeywordTransformer transformer = new KeywordTransformer();
        ArrayList input = new ArrayList();
        input.add(new Char('d'));
        input.add(new Char('o'));
        List result = (List) transformer.transform(input);
        assertTrue(result.get(0) instanceof Keyword);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform2() {
        KeywordTransformer transformer = new KeywordTransformer();
        ArrayList input = new ArrayList();
        input.add(new Char('d'));
        input.add(new Char('d'));
        List result = (List) transformer.transform(input);
        assertFalse(result.get(0) instanceof Keyword);
        assertTrue(result.get(0) instanceof Char);
        assertTrue(result.get(1) instanceof Char);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform3() {
        KeywordTransformer transformer = new KeywordTransformer();
        ArrayList input = new ArrayList();
        input.add(new Char('d'));
        input.add("no");
        List result = (List) transformer.transform(input);
        assertFalse(result.get(0) instanceof Keyword);
        assertTrue(result.get(0) instanceof Char);
        assertTrue(result.get(1) instanceof String);
    }
}
