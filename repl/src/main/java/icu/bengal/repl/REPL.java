package icu.bengal.repl;

import icu.bengal.parser.BengalLexer;
import icu.bengal.parser.BengalParser;
import java.util.Scanner;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

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
     * Stores the line(s).
     */
    private final StringBuilder lines = new StringBuilder();

    /**
     * Stores the scanner.
     */
    private Scanner scanner;

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
        BengalLexer lexer = new BengalLexer(CharStreams.fromString(lines.toString()));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        BengalParser parser = new BengalParser(tokenStream);
        result = parser.source().toStringTree();
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
        String line = scanner.nextLine();
        while (scanner.hasNext()) {
            lines.append(line).append("\n");
            if (!line.contains("/exit")) {
                line = scanner.nextLine();
            } else {
                lines.setLength(0);
                System.exit(0);
            }
        }
    }

    /**
     * REPL loop.
     */
    private void run() {
        setup();
        banner();
        while (!done) {
            prompt();
            read();
            eval();
            print();
            if (lines.isEmpty()) {
                done = true;
            }
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

    /**
     * Setup the REPL.
     */
    private void setup() {
        scanner = new Scanner(System.in);
    }
}
