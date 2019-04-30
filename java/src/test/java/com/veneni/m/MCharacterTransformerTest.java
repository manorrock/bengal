/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the MCharacterTransformer class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MCharacterTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        MCharacterTransformer transformer = new MCharacterTransformer();
        ArrayList input = new ArrayList();
        List output = transformer.transform(input);
        assertTrue(output.isEmpty());
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform2() {
        MCharacterTransformer transformer = new MCharacterTransformer();
        ArrayList input = new ArrayList();
        input.add('\'');
        List output = transformer.transform(input);
        assertTrue(output.get(0) instanceof Character);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform3() {
        MCharacterTransformer transformer = new MCharacterTransformer();
        ArrayList input = new ArrayList();
        input.add('\'');
        input.add('a');
        List output = transformer.transform(input);
        assertTrue(output.get(0) instanceof Character);
        assertTrue(output.get(1) instanceof Character);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform4() {
        MCharacterTransformer transformer = new MCharacterTransformer();
        ArrayList input = new ArrayList();
        input.add('\'');
        input.add("string");
        List output = transformer.transform(input);
        assertTrue(output.get(0) instanceof Character);
        assertTrue(output.get(1) instanceof String);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform5() {
        MCharacterTransformer transformer = new MCharacterTransformer();
        ArrayList input = new ArrayList();
        input.add("string");
        List output = transformer.transform(input);
        assertTrue(output.get(0) instanceof String);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform6() {
        MCharacterTransformer transformer = new MCharacterTransformer();
        ArrayList input = new ArrayList();
        input.add('a');
        List output = transformer.transform(input);
        assertTrue(output.get(0) instanceof Character);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform7() {
        MCharacterTransformer transformer = new MCharacterTransformer();
        ArrayList input = new ArrayList();
        input.add('\'');
        input.add('\'');
        List output = transformer.transform(input);
        assertTrue(output.get(0) instanceof MCharacter);
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform8() {
        MCharacterTransformer transformer = new MCharacterTransformer();
        ArrayList input = new ArrayList();
        input.add('\'');
        input.add('a');
        input.add('\'');
        List output = transformer.transform(input);
        assertTrue(output.get(0) instanceof MCharacter);
    }
}
