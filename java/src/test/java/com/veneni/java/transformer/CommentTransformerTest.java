/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.transformer;

import com.veneni.java.ast.AstComment;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the CommentTransformer.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class CommentTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        CommentTransformer transformer = new CommentTransformer();
        List output = transformer.transform(new ArrayList());
        assertTrue(output.isEmpty());
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform2() {
        CommentTransformer transformer = new CommentTransformer();
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
        CommentTransformer transformer = new CommentTransformer();
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
        CommentTransformer transformer = new CommentTransformer();
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
        CommentTransformer transformer = new CommentTransformer();
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
        CommentTransformer transformer = new CommentTransformer();
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
        CommentTransformer transformer = new CommentTransformer();
        ArrayList input = new ArrayList();
        input.add("this is a string which will not be parsed");
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof String);
    }
}
