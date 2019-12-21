/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Veneni M Java compiler.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class JavaCompiler implements Runnable {
    
    /**
     * Stores the logger.
     */
    private static final Logger LOGGER = Logger.getLogger(JavaCompiler.class.getName());

    /**
     * Stores the destination directory.
     */
    private File destinationDirectory;

    /**
     * Stores the source files.
     */
    private final ArrayList<String> sourceFiles;

    /**
     * Constructor.
     */
    public JavaCompiler() {
        destinationDirectory = null;
        sourceFiles = new ArrayList<>();
    }

    /**
     * Compile the source file.
     * 
     * @param sourceFile the source file.
     */
    private void compile(String sourceFile) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "Compiling: " + sourceFile);
        }
    }

    /**
     * Main method.
     *
     * @param arguments the arguments.
     */
    public static void main(String[] arguments) {
        JavaCompiler compiler = new JavaCompiler();
        compiler.parseArguments(arguments);
        compiler.run();
    }

    /**
     * Parse the arguments.
     *
     * @param arguments the arguments.
     */
    public void parseArguments(String[] arguments) {
        for (int i = 0; i < arguments.length; i++) {
            sourceFiles.add(arguments[i]);
        }
    }

    /**
     * Run the compiler.
     */
    @Override
    public void run() {
        sourceFiles.forEach((sourceFile) -> {
            compile(sourceFile);
        });
    }
}
