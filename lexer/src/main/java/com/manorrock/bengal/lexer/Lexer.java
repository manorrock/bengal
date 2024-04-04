package com.manorrock.bengal.lexer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * The Bengal Lexer.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Lexer {
    
    /**
     * Stores the left parenthesis constant.
     */
    private static String LEFT_PARENTHESIS = "(";
    
    /**
     * Stores the right parenthesis constant.
     */
    private static String RIGHT_PARENTHESIS = ")";
    
    /**
     * Stores the semi colon constant.
     */
    private static String SEMI_COLON = ";";

    /**
     * Main method.
     * 
     * @param arguments the command line arguments
     */
    public static void main(String[] arguments) {
        File inputFilename = new File(arguments[0]);
        try (LineNumberReader reader = new LineNumberReader(new FileReader(inputFilename))) {
            while(reader.ready()) {
                int character = reader.read();
                switch (character) {
                    case ';' ->                         {
                            LexerToken token = new LexerToken(SEMI_COLON, reader.getLineNumber());
                            System.out.println(token);
                        }
                    case '(' ->                         {
                            LexerToken token = new LexerToken(LEFT_PARENTHESIS, reader.getLineNumber());
                            System.out.println(token);
                        }
                    case ')' ->                         {
                            LexerToken token = new LexerToken(RIGHT_PARENTHESIS, reader.getLineNumber());
                            System.out.println(token);
                        }
                    default -> System.out.println((char) character);
                }
            }
        } catch(IOException ioe) {
            
        }
    }
}
