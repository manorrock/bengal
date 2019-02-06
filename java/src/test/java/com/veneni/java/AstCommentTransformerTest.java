/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the AstCommentTransformer.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstCommentTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        AstCommentTransformer transformer = new AstCommentTransformer();
        List output = transformer.transform(new ArrayList());
        assertTrue(output.isEmpty());
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform2() {
        AstCommentTransformer transformer = new AstCommentTransformer();
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
        AstCommentTransformer transformer = new AstCommentTransformer();
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
        AstCommentTransformer transformer = new AstCommentTransformer();
        ArrayList input = new ArrayList();
        input.add('/');
        input.add('*');
        input.add('*');
        input.add('/');
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof AstComment);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform5() {
        AstCommentTransformer transformer = new AstCommentTransformer();
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
        AstCommentTransformer transformer = new AstCommentTransformer();
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
        AstCommentTransformer transformer = new AstCommentTransformer();
        ArrayList input = new ArrayList();
        input.add("this is a string which will not be parsed");
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof String);
    }
}
