/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.io.File;
import java.io.IOException;
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
     * Stores the base directory.
     */
    private File baseDirectory;

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
        baseDirectory = new File(System.getProperty("user.dir"));
        destinationDirectory = new File(System.getProperty("user.dir"));
        sourceFiles = new ArrayList<>();
    }

    /**
     * Compile the source file.
     *
     * @param sourceFile the source file.
     */
    private void compile(String sourceFilename) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "Compiling: {0}", sourceFilename);
        }
        try {
            String destinationFilename = sourceFilename.substring(0, sourceFilename.lastIndexOf("."));
            destinationFilename = destinationFilename + ".java";
            File destinationFile = new File(destinationDirectory, destinationFilename);
            if (!destinationFile.exists()) {
                File destinationParent = destinationFile.getParentFile();
                if (destinationParent != null && !destinationParent.exists()) {
                    destinationParent.mkdirs();
                }
            }
            destinationFile.createNewFile();
        } catch (IOException ioe) {
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.log(Level.WARNING, "Unable to compile: " + sourceFilename, ioe);
            }
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
