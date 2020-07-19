/*
 *  Copyright (c) 2020, Manorrock.com. All Rights Reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *      1. Redistributions of source code must retain the above copyright
 *         notice, this list of conditions and the following disclaimer.
 *
 *      2. Redistributions in binary form must reproduce the above copyright
 *         notice, this list of conditions and the following disclaimer in the
 *         documentation and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 *  AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 *  IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 *  ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 *  LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 *  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 *  INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 *  CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 *  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 *  POSSIBILITY OF SUCH DAMAGE.
 */
package com.manorrock.bengal.message.runtime;

import java.util.HashMap;

/**
 * An object declaration.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class MessageObjectDeclaration {

    /**
     * Stores the methods.
     */
    private final HashMap<String, MessageMethodDeclaration> methods;

    /**
     * Stores the name.
     */
    private final String name;

    /**
     * Constructor.
     *
     * @param name the name of the object.
     */
    public MessageObjectDeclaration(String name) {
        this.methods = new HashMap<>();
        this.name = name;
    }

    /**
     * Add a method.
     *
     * @param methodDeclaration the method declaration.
     */
    public void addMethod(MessageMethodDeclaration methodDeclaration) {
        methods.put(methodDeclaration.getName(), methodDeclaration);
    }

    /**
     * Get the name.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * toString.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("object ").append(name);
        if (methods.size() > 0) {
            result.append("\n");
            methods.keySet().forEach(k -> {
                result.append("- method ").append(k).append("\n");
            });
        }
        return result.toString();
    }
}
