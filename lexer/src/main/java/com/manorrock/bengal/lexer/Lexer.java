package com.manorrock.bengal.lexer;

import com.manorrock.bengal.lexer.antlr4.BengalLexer;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

/**
 * The Bengal Lexer.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Lexer {

    /**
     * Main method.
     * 
     * @param arguments the command-line arguments.
     */
    public static void main(String[] arguments) {
        try {
            if (arguments.length != 1) {
                System.out.println("Usage: bl <input-filename>");
                System.exit(1);
            }
            
            String inputFilename = arguments[0];
            CharStream input = CharStreams.fromFileName(inputFilename);
            BengalLexer lexer = new BengalLexer(input);
            
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();
            
            for (Token token : tokens.getTokens()) {
                System.out.println(token);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
