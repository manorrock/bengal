/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.io.File;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the JavaCompiler.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class JavaCompilerTest {

    /**
     * Test run method.
     */
    @Test
    public void testRun() {
        JavaCompiler compiler = new JavaCompiler();
        compiler.parseArguments(new String[]{"src/test/veneni/m/HelloWorld.m"});
        compiler.run();
        File destinationFile = new File("src/test/veneni/m/HelloWorld.java");
        assertTrue(destinationFile.exists());
        destinationFile.delete();
    }
}
