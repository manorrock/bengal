/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the AstCharacterTransformer class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstCharacterTransformerTest {

    /**
     * Test run method.
     */
    @Test
    public void testRun() {
        AstCharacterTransformer transformer = new AstCharacterTransformer();
        transformer.getInput().addFirst(new Done());
        transformer.run();
        assertTrue(transformer.getOutput().pollLast() instanceof Done);
    }

    /**
     * Test run method.
     */
    @Test
    public void testRun2() {
        AstCharacterTransformer transformer = new AstCharacterTransformer();
        transformer.getInput().addFirst('\'');
        transformer.getInput().addFirst(new Done());
        transformer.run();
        assertTrue(transformer.getOutput().pollLast() instanceof Character);
        assertTrue(transformer.getOutput().pollLast() instanceof Done);
    }

    /**
     * Test run method.
     */
    @Test
    public void testRun3() {
        AstCharacterTransformer transformer = new AstCharacterTransformer();
        transformer.getInput().addFirst('\'');
        transformer.getInput().addFirst('a');
        transformer.getInput().addFirst(new Done());
        transformer.run();
        assertTrue(transformer.getOutput().pollLast() instanceof Character);
        assertTrue(transformer.getOutput().pollLast() instanceof Character);
        assertTrue(transformer.getOutput().pollLast() instanceof Done);
    }

    /**
     * Test run method.
     */
    @Test
    public void testRun4() {
        AstCharacterTransformer transformer = new AstCharacterTransformer();
        transformer.getInput().addFirst('\'');
        transformer.getInput().addFirst("string");
        transformer.getInput().addFirst(new Done());
        transformer.run();
        assertTrue(transformer.getOutput().pollLast() instanceof Character);
        assertTrue(transformer.getOutput().pollLast() instanceof String);
        assertTrue(transformer.getOutput().pollLast() instanceof Done);
    }

    /**
     * Test run method.
     */
    @Test
    public void testRun5() {
        AstCharacterTransformer transformer = new AstCharacterTransformer();
        transformer.getInput().addFirst("string");
        transformer.getInput().addFirst(new Done());
        transformer.run();
        assertTrue(transformer.getOutput().pollLast() instanceof String);
        assertTrue(transformer.getOutput().pollLast() instanceof Done);
    }

    /**
     * Test run method.
     */
    @Test
    public void testRun6() {
        AstCharacterTransformer transformer = new AstCharacterTransformer();
        transformer.getInput().addFirst('a');
        transformer.getInput().addFirst(new Done());
        transformer.run();
        assertTrue(transformer.getOutput().pollLast() instanceof Character);
        assertTrue(transformer.getOutput().pollLast() instanceof Done);
    }

    /**
     * Test run method.
     */
    @Test
    public void testRun7() {
        AstCharacterTransformer transformer = new AstCharacterTransformer();
        transformer.getInput().addFirst('\'');
        transformer.getInput().addFirst('\'');
        transformer.getInput().addFirst(new Done());
        transformer.run();
        assertTrue(transformer.getOutput().pollLast() instanceof AstCharacter);
        assertTrue(transformer.getOutput().pollLast() instanceof Done);
    }

    /**
     * Test run method.
     */
    @Test
    public void testRun8() {
        AstCharacterTransformer transformer = new AstCharacterTransformer();
        transformer.getInput().addFirst('\'');
        transformer.getInput().addFirst('a');
        transformer.getInput().addFirst('\'');
        transformer.getInput().addFirst(new Done());
        transformer.run();
        assertTrue(transformer.getOutput().pollLast() instanceof AstCharacter);
        assertTrue(transformer.getOutput().pollLast() instanceof Done);
    }
}
