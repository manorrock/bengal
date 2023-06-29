package icu.bengal.repl;

import java.io.Console;

/**
 * The main entry point.
 *
 * @author Manfred Riem (manfred@bengal.icu)
 */
public class REPL {
    
    /**
     * Stores the console.
     */
    private Console console = System.console();

    /**
     * Stores the done flag.
     */
    private boolean done;

    /**
     * Stores the line(s).
     */
    private StringBuilder lines = new StringBuilder();

    /**
     * Stores the result.
     */
    private String result;

    /**
     * Show the banner.
     */
    private void banner() {
        System.out.println(
                """
-------------------------------------------------------------------------------
  Bengal REPL - Enjoy!
-------------------------------------------------------------------------------""");
    }

    /**
     * Evaluate.
     */
    private void eval() {
        result = lines.toString();
    }

    /**
     * Print
     */
    private void print() {
        System.out.println(result);
    }

    /**
     * Prompt
     */
    private void prompt() {
        System.out.print("$ ");
    }

    /**
     * Read.
     */
    private void read() {
        lines.setLength(0);
        String line = console.readLine();
        while(line != null) {
            lines.append(line).append("\n");
            line = console.readLine();
        }
    }

    /**
     * REPL loop.
     */
    private void run() {
        banner();
        while (!done) {
            prompt();
            read();
            eval();
            print();
        }
    }

    /**
     * The main method.
     *
     * @param arguments the command line arguments
     */
    public static void main(String[] arguments) {
        REPL repl = new REPL();
        repl.run();
    }
}
