/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.emitter;

import com.veneni.java.ast.AstMethod;

/**
 * The Java emitter.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
class MethodEmitter {
    
    /**
     * Emit the AstMethod.
     * 
     * @param method the AstMethod.
     * @return the Java equivalent for the AstMethod.
     */
    public String emit(AstMethod method) {
        StringBuilder builder = new StringBuilder();
        builder.append("public void ").append(method.getName()).append("() {\n");
        builder.append("}");
        return builder.toString();
    }
}
