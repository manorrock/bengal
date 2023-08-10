package icu.bengal.repl;

import icu.bengal.parser.BengalLexer;
import icu.bengal.parser.BengalParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
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
     * Stores the reader.
     */
    private LineNumberReader reader;

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
        try {
            lines.setLength(0);
            String line = reader.readLine();
            while (line != null) {
                lines.append(line).append("\n");
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
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
        reader = new LineNumberReader(new InputStreamReader(System.in));
    }
}
