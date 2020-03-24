/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.message;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * The Veneni Message CLI.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class VeneniMessageCli {

    /**
     * Stores the shutdown flag.
     */
    private boolean shutdown;

    /**
     * Run method.
     */
    public void run() {
        LineNumberReader lineReader = new LineNumberReader(new InputStreamReader(System.in));
        while (!shutdown) {
            try {
                String line = lineReader.readLine();
                switch (line) {
                    case "/quit":
                        System.exit(0);
                        break;
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }

    /**
     * Main method.
     *
     * @param arguments the arguments.
     */
    public static void main(String[] arguments) {
        VeneniMessageCli cli = new VeneniMessageCli();
        cli.run();
    }
}
