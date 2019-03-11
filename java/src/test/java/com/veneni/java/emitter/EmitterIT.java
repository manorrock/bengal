/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.emitter;

import com.veneni.java.ast.AstObject;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the Emitter class.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class EmitterIT {
    
    /**
     * Test emit method.
     */
    @Test
    public void testEmit() {
        Emitter emitter = new Emitter();
        String result = emitter.emit(new AstObject("MyObject"));
        assertTrue(result.contains("public class "));
        assertTrue(result.contains("MyObject"));
        System.out.println(result);
    }
}
