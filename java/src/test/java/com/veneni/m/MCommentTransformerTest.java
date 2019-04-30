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
 * The JUnit tests for the MCommentTransformer class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MCommentTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        MCommentTransformer transformer = new MCommentTransformer();
        List output = transformer.transform(new ArrayList());
        assertTrue(output.isEmpty());
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform2() {
        MCommentTransformer transformer = new MCommentTransformer();
        ArrayList input = new ArrayList();
        input.add('/');
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0).equals('/'));
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform3() {
        MCommentTransformer transformer = new MCommentTransformer();
        ArrayList input = new ArrayList();
        input.add('/');
        input.add('*');
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0).equals('/'));
        assertTrue(output.get(1).equals('*'));
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform4() {
        MCommentTransformer transformer = new MCommentTransformer();
        ArrayList input = new ArrayList();
        input.add('/');
        input.add('*');
        input.add('*');
        input.add('/');
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof MComment);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform5() {
        MCommentTransformer transformer = new MCommentTransformer();
        ArrayList input = new ArrayList();
        input.add('*');
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0).equals('*'));
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform6() {
        MCommentTransformer transformer = new MCommentTransformer();
        ArrayList input = new ArrayList();
        input.add('/');
        input.add('-');
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0).equals('/'));
        assertTrue(output.get(1).equals('-'));
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform7() {
        MCommentTransformer transformer = new MCommentTransformer();
        ArrayList input = new ArrayList();
        input.add("this is a string which will not be parsed");
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof String);
    }
}
