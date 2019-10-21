/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.List;
import org.junit.Test;

/**
 * The JUnit tests for the MParser class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MParserTest {

    /**
     * Test parse method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testParse7() throws Exception {
        MParser parser = new MParser();
        List result = (List) parser.parse("src/test/veneni/If.m");
//        assertTrue(result.get(0) instanceof MKeyword);
    }

    /**
     * Test parse method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testParse8() throws Exception {
        MParser parser = new MParser();
        List result = (List) parser.parse("src/test/veneni/Then.m");
//        assertTrue(result.get(0) instanceof MKeyword);
    }

    /**
     * Test parse method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testParse9() throws Exception {
        MParser parser = new MParser();
        List result = (List) parser.parse("src/test/veneni/Else.m");
//        assertTrue(result.get(0) instanceof MKeyword);
    }

    /**
     * Test parse method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testParse10() throws Exception {
        MParser parser = new MParser();
        List result = (List) parser.parse("src/test/veneni/While.m");
//        assertTrue(result.get(0) instanceof MKeyword);
    }

    /**
     * Test parse method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testParse11() throws Exception {
        MParser parser = new MParser();
        List result = (List) parser.parse("src/test/veneni/Do.m");
//        assertTrue(result.get(0) instanceof MKeyword);
    }

    /**
     * Test parse method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testParse12() throws Exception {
        MParser parser = new MParser();
        List result = (List) parser.parse("src/test/veneni/For.m");
//        assertTrue(result.get(0) instanceof MKeyword);
    }

    /**
     * Test parse method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testParse13() throws Exception {
        MParser parser = new MParser();
        List result = (List) parser.parse("src/test/veneni/Native.m");
//        assertTrue(result.get(0) instanceof MKeyword);
    }
}
