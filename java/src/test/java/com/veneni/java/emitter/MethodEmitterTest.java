/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.emitter;

import com.veneni.java.ast.AstMethod;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The JUnit tests for the MethodEmitter.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MethodEmitterTest {
    
    /**
     * Test emit method.
     */
    @Test
    public void testEmit() {
        AstMethod method = new AstMethod("mymethod");
        MethodEmitter emitter = new MethodEmitter();
        String result = emitter.emit(method);
        assertTrue(result.contains("public void mymethod()"));
    }
    
}
