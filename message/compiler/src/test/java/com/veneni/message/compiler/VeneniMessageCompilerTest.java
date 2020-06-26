/*
 * Copyright (c) 2002-2020 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.compiler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * The JUnit tests for the VeneniMessageCompiler class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class VeneniMessageCompilerTest {
    
    /**
     * Test execute method.
     */
    @Test
    public void testExecute() {
        VeneniMessageCompiler compiler = new VeneniMessageCompiler();
        PrintStream original = System.out;
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteOutput));
        compiler.execute(new String[] {"src/test/vmesg/true.vmesg"});
        assertEquals("true\n", byteOutput.toString());
        System.setOut(original);
    }
    
    /**
     * Test execute method.
     */
    @Test
    public void testExecute2() {
        VeneniMessageCompiler compiler = new VeneniMessageCompiler();
        PrintStream original = System.out;
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteOutput));
        compiler.execute(new String[] {"src/test/vmesg/false.vmesg"});
        assertEquals("false\n", byteOutput.toString());
        System.setOut(original);
    }
    
    /**
     * Test execute method.
     */
    @Test
    public void testExecute3() {
        VeneniMessageCompiler compiler = new VeneniMessageCompiler();
        PrintStream original = System.out;
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteOutput));
        compiler.execute(new String[] {"src/test/vmesg/MyObject.vmesg"});
        String output = byteOutput.toString();
        assertTrue(output.contains("public class Object1"));
        assertTrue(output.contains("VENENI_OBJECT_NAME = \"MyObject\""));
        System.setOut(original);
    }
    
    /**
     * Test execute method.
     */
    @Test
    public void testExecute4() {
        VeneniMessageCompiler compiler = new VeneniMessageCompiler();
        PrintStream original = System.out;
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteOutput));
        compiler.execute(new String[] {"src/test/vmesg/nil.vmesg"});
        String output = byteOutput.toString();
        assertTrue(output.contains("Object0.INSTANCE"));
        System.setOut(original);
    }
}
