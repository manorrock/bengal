/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m.java;

import com.veneni.m.MComment;
import com.veneni.m.MMethod;
import com.veneni.m.MObject;
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
        if (object instanceof MComment) {
            result.append(emitComment((MComment) object));
        }
        if (object instanceof MMethod) {
            result.append(emitMethod((MMethod) object));
        }
        if (object instanceof MObject) {
            result.append(emitObject((MObject) object));
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
     * Emit the MComment.
     *
     * @param comment the MComment.
     * @return the Java comment.
     */
    public String emitComment(MComment comment) {
        StringBuilder builder = new StringBuilder();
        builder.append("/*").append(comment.getComment()).append("*/");
        return builder.toString();
    }

    /**
     * Emit the MMethod.
     *
     * @param method the MMethod.
     * @return the Java equivalent for the MMethod.
     */
    public String emitMethod(MMethod method) {
        StringBuilder builder = new StringBuilder();
        builder.append("public void ").append(method.getName()).append("() {\n");
        builder.append("}");
        return builder.toString();
    }

    /**
     * Emit the MObject.
     *
     * @param object the MObject.
     * @return the Java equivalent for the MObject.
     */
    public String emitObject(MObject object) {
        StringBuilder builder = new StringBuilder();
        builder.append("public class ").append(object.getName()).append(" {\n");
        for (MMethod method : object.getMethods()) {
            builder.append("\n");
            builder.append(emitMethod(method));
            builder.append("\n");
        }
        builder.append("}");
        return builder.toString();
    }
}
