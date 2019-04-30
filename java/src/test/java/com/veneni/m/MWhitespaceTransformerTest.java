/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the MWhitespaceTransformer class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MWhitespaceTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        MWhitespaceTransformer transformer = new MWhitespaceTransformer();
        ArrayList input = new ArrayList();
        input.add(' ');
        List result = transformer.transform(input);
        assertTrue(result.get(0) instanceof MWhitespace);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform2() {
        MWhitespaceTransformer transformer = new MWhitespaceTransformer();
        ArrayList input = new ArrayList();
        input.add(" ");
        List result = transformer.transform(input);
        assertTrue(result.get(0) instanceof String);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform3() {
        MWhitespaceTransformer transformer = new MWhitespaceTransformer();
        ArrayList input = new ArrayList();
        input.add('a');
        List result = transformer.transform(input);
        assertTrue(result.get(0) instanceof Character);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform4() {
        MWhitespaceTransformer transformer = new MWhitespaceTransformer();
        ArrayList input = new ArrayList();
        input.add(' ');
        input.add(' ');
        input.add('a');
        List result = transformer.transform(input);
        assertTrue(result.get(0) instanceof MWhitespace);
        assertTrue(result.get(1) instanceof Character);
    }
}
