/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the MParser class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MParserTest {

    /**
     * Test parse method.
     */
    @Test
    public void testParse() {
        ArrayList input = new ArrayList();
        input.add('/');
        input.add('*');
        input.add('*');
        input.add('/');
        MParser parser = new MParser();
        Object result = parser.parse(input);
        assertTrue(result instanceof List);
        List list = (List) result;
        assertTrue(list.get(0) instanceof MComment);
    }

    /**
     * Test parse method.
     */
    @Test
    public void testParse2() {
        ArrayList input = new ArrayList();
        input.add('/');
        input.add('*');
        input.add('*');
        input.add('/');
        input.add('\'');
        input.add('a');
        input.add('\'');
        MParser parser = new MParser();
        Object result = parser.parse(input);
        assertTrue(result instanceof List);
        List list = (List) result;
        assertTrue(list.get(0) instanceof MComment);
//        assertTrue(list.get(1) instanceof MCharacter);
    }

    /**
     * Test parse method.
     */
    @Test
    public void testParse3() {
        ArrayList input = new ArrayList();
        input.add('/');
        input.add('*');
        input.add('*');
        input.add('/');
        input.add('\'');
        input.add('a');
        input.add('\'');
        input.add('\"');
        input.add('s');
        input.add('\"');
        MParser parser = new MParser();
        Object result = parser.parse(input);
        assertTrue(result instanceof List);
        List list = (List) result;
        assertTrue(list.get(0) instanceof MComment);
//        assertTrue(list.get(1) instanceof MCharacter);
//        assertTrue(list.get(2) instanceof MString);
    }

    /**
     * Test parse method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testParse4() throws Exception {
        MParser parser = new MParser();
        List result = (List) parser.parse("src/test/veneni/Comment.m");
        assertTrue(result.get(0) instanceof MComment);
    }

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
