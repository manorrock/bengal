/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * The JUnit tests for the WhitespaceTransformer class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class WhitespaceTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        ArrayList input = new ArrayList();
        input.add(new Char('/'));
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        Object output = transformer.transform(input);
        if (output instanceof List) {
            List list = (List) output;
            assertTrue(list.get(0) instanceof Char);
        } else {
            fail("Not a list");
        }
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform2() {
        ArrayList input = new ArrayList();
        input.add(new Char('/'));
        input.add(new Char(' '));
        input.add(new Char('*'));
        input.add(new Char('/'));
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        Object output = transformer.transform(input);
        if (output instanceof List) {
            List list = (List) output;
            assertTrue(list.get(0) instanceof Char);
            assertTrue(list.get(1) instanceof Whitespace);
            assertTrue(list.get(2) instanceof Char);
            assertTrue(list.get(3) instanceof Char);
        } else {
            fail("Not a list");
        }
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform3() {
        ArrayList input = new ArrayList();
        input.add(new Char('a'));
        input.add(new Char('\t'));
        input.add(new Char('c'));
        input.add(new Char('d'));
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        Object output = transformer.transform(input);
        if (output instanceof List) {
            List list = (List) output;
            assertTrue(list.get(0) instanceof Char);
            assertTrue(list.get(1) instanceof Whitespace);
            assertTrue(list.get(2) instanceof Char);
            assertTrue(list.get(3) instanceof Char);
            assertEquals(4, list.size());
        } else {
            fail("Not a list");
        }
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform4() {
        ArrayList input = new ArrayList();
        input.add(new Char('a'));
        input.add(new Char('b'));
        input.add(new Char('c'));
        input.add("d");
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        Object output = transformer.transform(input);
        if (output instanceof List) {
            List list = (List) output;
            assertTrue(list.get(0) instanceof Char);
            assertTrue(list.get(3) instanceof String);
            assertEquals(4, list.size());
        } else {
            fail("Not a list");
        }
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform5() {
        ArrayList input = new ArrayList();
        input.add(new Char(' '));
        input.add(new Char(' '));
        input.add(new Char('c'));
        input.add("d");
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        Object output = transformer.transform(input);
        if (output instanceof List) {
            List list = (List) output;
            assertTrue(list.get(0) instanceof Whitespace);
            assertEquals("  ", list.get(0).toString());
            assertTrue(list.get(1) instanceof Char);
            assertTrue(list.get(2) instanceof String);
            assertEquals(3, list.size());
        } else {
            fail("Not a list");
        }
    }
}
