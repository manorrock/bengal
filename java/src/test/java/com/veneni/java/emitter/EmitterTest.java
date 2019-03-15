/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.emitter;

import com.veneni.java.ast.AstMethod;
import com.veneni.java.ast.AstObject;
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
        String result = emitter.emit(new AstObject("MyObject"));
        assertTrue(result.contains("public class "));
        assertTrue(result.contains("MyObject"));
    }
    
    /**
     * Test emit method.
     */
    @Test
    public void testEmit2() {
        AstObject object = new AstObject("MyObject");
        object.getMethods().add(new AstMethod("myMethod"));
        Emitter emitter = new Emitter();
        String result = emitter.emit(object);
        assertTrue(result.contains("public class "));
        assertTrue(result.contains("public void myMethod"));
        assertTrue(result.contains("MyObject"));
    }
}
