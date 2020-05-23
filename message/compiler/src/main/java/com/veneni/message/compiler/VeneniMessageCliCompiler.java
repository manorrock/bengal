/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.compiler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * The Veneni Message CLI compiler.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class VeneniMessageCliCompiler {

    /**
     * Stores the compiler.
     */
    private final VeneniMessageCompiler compiler;

    /**
     * Stores the list of inputs we are going to compile.
     */
    private final ArrayList<String> inputs;

    /**
     * Constructor.
     */
    public VeneniMessageCliCompiler() {
        compiler = new VeneniMessageCompiler();
        inputs = new ArrayList<>();
    }

    /**
     * Compile the input file.
     */
    private void compileInput(String inputFile) {
        try {
            Path path = new File(inputFile).toPath();
            byte[] bytes = Files.readAllBytes(path);
            String output = compiler.compile(new String(bytes));
            System.out.println(output);
        } catch (IOException ioe) {
            ioe.printStackTrace(System.out);
        }
    }

    /**
     * Compile the inputs.
     */
    private void compileInputs() {
        while(!inputs.isEmpty()) {
            String inputFile = inputs.remove(0);
            compileInput(inputFile);
        }
    }

    /**
     * Execute the compiler.
     *
     * @param arguments the command line arguments.
     */
    public void execute(String[] arguments) {
        parseArguments(arguments);
        compileInputs();
    }

    /**
     * Parse the arguments.
     *
     * @param arguments the arguments.
     */
    private void parseArguments(String[] arguments) {
        for (int i = 0; i < arguments.length; i++) {
            inputs.add(arguments[i]);
        }
    }

    /**
     * Main method.
     *
     * @param arguments the command line arguments.
     */
    public static void main(String[] arguments) {
        VeneniMessageCliCompiler compiler = new VeneniMessageCliCompiler();
        compiler.execute(arguments);
    }
}
