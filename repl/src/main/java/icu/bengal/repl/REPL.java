package icu.bengal.repl;

import java.util.Scanner;

/**
 * The main entry point.
 *
 * @author Manfred Riem (manfred@bengal.icu)
 */
public class REPL {

    /**
     * Stores the done flag.
     */
    private boolean done;

    /**
     * Stores the line.
     */
    private String line;

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
        result = line;
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
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
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
