/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.parser;

import com.veneni.java.ast.AstCharacter;
import com.veneni.java.ast.AstComment;
import com.veneni.java.ast.AstKeyword;
import com.veneni.java.ast.AstString;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the Parser class.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class ParserTest {

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
        Parser parser = new Parser();
        Object result = parser.parse(input);
        assertTrue(result instanceof List);
        List list = (List) result;
        assertTrue(list.get(0) instanceof AstComment);
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
        Parser parser = new Parser();
        Object result = parser.parse(input);
        assertTrue(result instanceof List);
        List list = (List) result;
        assertTrue(list.get(0) instanceof AstComment);
        assertTrue(list.get(1) instanceof AstCharacter);
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
        Parser parser = new Parser();
        Object result = parser.parse(input);
        assertTrue(result instanceof List);
        List list = (List) result;
        assertTrue(list.get(0) instanceof AstComment);
        assertTrue(list.get(1) instanceof AstCharacter);
        assertTrue(list.get(2) instanceof AstString);
    }

    /**
     * Test parse method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testParse4() throws Exception {
        Parser parser = new Parser();
        List result = (List) parser.parse("src/test/veneni/Comment.m");
        assertTrue(result.get(0) instanceof AstComment);
    }

    /**
     * Test parse method.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testParse5() throws Exception {
        Parser parser = new Parser();
        List result = (List) parser.parse("src/test/veneni/Class.m");
        assertTrue(result.get(0) instanceof AstKeyword);
    }
}
