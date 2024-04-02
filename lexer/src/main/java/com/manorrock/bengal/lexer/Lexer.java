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
                if (character == ';') {
                    LexerToken token = new LexerToken(SEMI_COLON, reader.getLineNumber());
                    System.out.println(token);
                } else {
                    System.out.println((char) character);
                }
            }
        } catch(IOException ioe) {
            
        }
    }
}
