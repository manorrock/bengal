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
 * The JUnit tests for the MStringTransformer class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MStringTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        MStringTransformer transformer = new MStringTransformer();
        List output = transformer.transform(new ArrayList());
        assertTrue(output.isEmpty());
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform2() {
        MStringTransformer transformer = new MStringTransformer();
        ArrayList input = new ArrayList();
        input.add('"');
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0).equals('"'));
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform3() {
        MStringTransformer transformer = new MStringTransformer();
        ArrayList input = new ArrayList();
        input.add('"');
        input.add('a');
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0).equals('"'));
        assertTrue(output.get(1).equals('a'));
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform4() {
        MStringTransformer transformer = new MStringTransformer();
        ArrayList input = new ArrayList();
        input.add('"');
        input.add('a');
        input.add('"');
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof MString);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform5() {
        MStringTransformer transformer = new MStringTransformer();
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
    public void testTransform7() {
        MStringTransformer transformer = new MStringTransformer();
        ArrayList input = new ArrayList();
        input.add("this is a string which will not be parsed");
        List output = transformer.transform(input);
        assertFalse(output.isEmpty());
        assertTrue(output.get(0) instanceof String);
    }
}
