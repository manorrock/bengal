/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.transformer;

import com.veneni.java.ast.AstWhitespace;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the WhitespaceTransformer.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class WhitespaceTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        ArrayList input = new ArrayList();
        input.add(' ');
        List result = transformer.transform(input);
        assertTrue(result.get(0) instanceof AstWhitespace);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform2() {
        WhitespaceTransformer transformer = new WhitespaceTransformer();
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
        WhitespaceTransformer transformer = new WhitespaceTransformer();
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
        WhitespaceTransformer transformer = new WhitespaceTransformer();
        ArrayList input = new ArrayList();
        input.add(' ');
        input.add(' ');
        input.add('a');
        List result = transformer.transform(input);
        assertTrue(result.get(0) instanceof AstWhitespace);
        assertTrue(result.get(1) instanceof Character);
    }
}
