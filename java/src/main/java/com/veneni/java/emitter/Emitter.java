/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.emitter;

import com.veneni.java.ast.AstMethod;
import com.veneni.java.ast.AstObject;

/**
 * The Java emitter.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Emitter {
    
    /**
     * Emit the AstObject.
     * 
     * @param object the AstObject.
     * @return the Java equivalent for the AstObject.
     */
    public String emit(AstObject object) {
        StringBuilder builder = new StringBuilder();
        builder.append("public class ").append(object.getName()).append(" {\n");
        MethodEmitter emitter = new MethodEmitter();
        for (AstMethod method : object.getMethods()) {
            builder.append("\n");
            builder.append(emitter.emit(method));
            builder.append("\n");
        }
        builder.append("}");
        return builder.toString();
    }
}
