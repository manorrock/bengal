/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * The interpreter.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Interpreter {

    /**
     * Stores the input reader.
     */
    private BufferedReader inputReader;

    /**
     * Stores the output writer.
     */
    private PrintWriter outputWriter;

    /**
     * Stores the parser.
     */
    private Parser parser;

    /**
     * Constructor.
     */
    public Interpreter(InputStream inputStream, OutputStream outputStream) {
        this.inputReader = new BufferedReader(new InputStreamReader(inputStream));
        this.outputWriter = new PrintWriter(outputStream, true);
        this.parser = new Parser();
    }

    /**
     * Main method.
     * 
     * @param arguments the arguments.
     */
    public static void main(String[] arguments) {
        Interpreter interpreter = new Interpreter(System.in, System.out);
        interpreter.run();
    }

    /**
     * Run method.
     */
    public void run() {
        for(;;) {
            try {
                String line = inputReader.readLine();
                Object object = parser.parse(line);
                outputWriter.println(object);
            } catch(IOException ioe) {
                ioe.printStackTrace(System.err);
            }
        }
    }
}
