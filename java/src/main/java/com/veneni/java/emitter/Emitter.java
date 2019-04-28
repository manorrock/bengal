/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java.emitter;

import com.veneni.java.ast.AstComment;
import com.veneni.java.ast.AstMethod;
import com.veneni.java.ast.AstObject;
import java.util.List;

/**
 * The Java emitter.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Emitter {
    
    /**
     * Emit any object.
     * 
     * @param object the object.
     * @return the Java equivalent.
     */
    public String emit(Object object) {
        StringBuilder result = new StringBuilder();
        if (object instanceof AstObject) {
            result.append(emit((AstObject) object));
        }
        if (object instanceof AstComment) {
            result.append(emitComment((AstComment) object));
        }
        if (object instanceof List) {
            List list = (List) object;
            list.forEach((item) -> {
                result.append(emit(item)).append("\n");
            });
        }
        return result.toString();
    }
    
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
    
    /**
     * Emit a comment.
     * 
     * @param comment the comment.
     * @return the Java comment.
     */
    public String emitComment(AstComment comment) {
        StringBuilder builder = new StringBuilder();
        builder.append("/*").append(comment.getComment()).append("*/");
        return builder.toString();
    }
}
