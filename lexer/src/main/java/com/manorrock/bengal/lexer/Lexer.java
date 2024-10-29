/*
 * Copyright (c) 2002-2024 Manorrock.com. All Rights Reserved.
 */
package com.manorrock.bengal.lexer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The Bengal Lexer.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Lexer {

    /**
     * Stores the arguments.
     */
    private String[] arguments;

    /**
     * Stores the input file.
     */
    private File inputFile;

    /**
     * Stores the output file.
     */
    private File outputFile;

    /**
     * Run method.
     */
    public void run() {
        parseArguments();
        processFile();
    }

    /**
     * Parse the arguments.
     */
    public void parseArguments() {
        if (arguments.length >= 2) {
            inputFile = new File(arguments[arguments.length - 2]);
            outputFile = new File(arguments[arguments.length - 1]);
        }
    }

    /**
     * Process the file.
     */
    private void processFile() {
        try {
            String input = Files
                    .lines(inputFile.toPath())
                    .collect(Collectors.joining("\n"));

            System.out.println(input);
            
            outputFile.getParentFile().mkdirs();
            
            String output = processString(input);
            System.out.println(output);
            
            Files.write(outputFile.toPath(), 
                    output.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /**
     * Process the input.
     * 
     * @param input the input.
     * @return the output.
     */
    public String processString(String input) {
        return input;
    }

    /**
     * Set the arguments.
     *
     * @param arguments the arguments.
     */
    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    /**
     * Main method.
     *
     * @param arguments the command-line arguments.
     */
    public static void main(String[] arguments) {
        Lexer lexer = new Lexer();
        lexer.setArguments(arguments);
        lexer.run();
    }
}
