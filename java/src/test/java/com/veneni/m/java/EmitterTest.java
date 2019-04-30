/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m.java;

import com.veneni.m.MMethod;
import com.veneni.m.MObject;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the Emitter class.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class EmitterTest {
    
    /**
     * Test emit method.
     */
    @Test
    public void testEmit() {
        Emitter emitter = new Emitter();
        String result = emitter.emit(new MObject("MyObject"));
        assertTrue(result.contains("public class "));
        assertTrue(result.contains("MyObject"));
    }
    
    /**
     * Test emit method.
     */
    @Test
    public void testEmit2() {
        MObject object = new MObject("MyObject");
        object.getMethods().add(new MMethod("myMethod"));
        Emitter emitter = new Emitter();
        String result = emitter.emit(object);
        assertTrue(result.contains("public class "));
        assertTrue(result.contains("public void myMethod"));
        assertTrue(result.contains("MyObject"));
    }

    /**
     * Test emit method.
     */
    @Test
    public void testEmit3() {
        MMethod method = new MMethod("mymethod");
        Emitter emitter = new Emitter();
        String result = emitter.emit(method);
        assertTrue(result.contains("public void mymethod()"));
    }
}
