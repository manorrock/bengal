/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import com.veneni.m.java.JavaCompiler;

/**
 * The compiler.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Compiler {
    
    /**
     * Main method.
     * 
     * @param arguments the arguments.
     * @throws Exception when an serious error occurs.
     */
    public static void main(String[] arguments) throws Exception {
        JavaCompiler javaCompiler = new JavaCompiler();
        javaCompiler.execute(arguments[0], arguments[1]);
    }
}
