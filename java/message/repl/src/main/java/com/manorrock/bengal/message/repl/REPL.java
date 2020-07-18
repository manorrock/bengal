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
package com.manorrock.bengal.message.repl;

import com.manorrock.bengal.message.parser.Parser;
import java.io.Console;

/**
 * The Bengal Message REPL.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class REPL implements Runnable {

    /**
     * Stores the console.
     */
    private final Console console;

    /**
     * Stores the input.
     */
    private String input;

    /**
     * Stores the output.
     */
    private String output;

    /**
     * Constructor.
     */
    public REPL() {
        console = System.console();
    }

    /**
     * Execute the input.
     */
    private void execute() {
        if (input.equals("exit")) {
            System.exit(0);
        } else {
            Parser parser = new Parser();
            Object parsed = parser.parse(input);
            if (parsed != null) {
                output = parsed.toString();
            } else {
                output = "Unable to parse: " + input;
            }
        }
    }

    /**
     * Print the output.
     */
    private void print() {
        if (output != null) {
            console.writer().println(output);
        }
        output = null;
    }

    /**
     * Read the input.
     */
    private void read() {
        StringBuilder read = new StringBuilder();
        String string = console.readLine();
        while (string.endsWith("\\")) {
            read.append(string.substring(0, string.length() - 1));
            string = console.readLine();
        }
        read.append(string);
        input = read.toString();
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        for (;;) {
            prompt();
            read();
            execute();
            print();
        }
    }

    /**
     * Parse the command-line arguments.
     *
     * @param arguments the command-line arguments.
     * @return the REPL.
     */
    public REPL arguments(String[] arguments) {
        return this;
    }

    /**
     * Main method.
     *
     * @param arguments the command-line arguments.
     */
    public static void main(String[] arguments) {
        REPL repl = new REPL();
        repl.arguments(arguments);
        repl.run();
    }

    /**
     * Write the prompt.
     */
    private void prompt() {
        console.writer().print("-> ");
        console.writer().flush();
    }
}
