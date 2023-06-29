package icu.bengal.repl;

import icu.bengal.parser.BengalLexer;
import icu.bengal.parser.BengalParser;
import java.io.Console;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

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
        BengalLexer lexer = new BengalLexer(CharStreams.fromString(lines.toString()));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        BengalParser parser = new BengalParser(tokenStream);
        result = parser.assignment().toStringTree();
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
