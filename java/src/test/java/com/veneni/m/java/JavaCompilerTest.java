/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the JavaCompiler class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class JavaCompilerTest {

    /**
     * Test main method.
     * 
     * @throws Exception when a serious error occurs.
     */
    @Test
    public void testHelloWorld() throws Exception {
        JavaCompiler compiler = new JavaCompiler();
        compiler.execute(
            "src/test/veneni/m/HelloWorld.m", 
            "target/HelloWorld.java");
        String contents = new String(Files.readAllBytes(Paths.get("target/HelloWorld.java")));
        assertTrue(contents.contains(" * The Veneni-M Hello World example"));
    }
}
