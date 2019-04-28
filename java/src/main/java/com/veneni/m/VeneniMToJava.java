/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import com.veneni.java.ast.AstObject;
import com.veneni.java.emitter.Emitter;
import com.veneni.parser.Parser;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Translate Veneni M to Java.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class VeneniMToJava {
    
    /**
     * Main method.
     * 
     * @param arguments the arguments.
     * @throws Exception when an serious error occurs.
     */
    public static void main(String[] arguments) throws Exception {
        Parser parser = new Parser();
        Object astTree = parser.parse(arguments[0]);
        try (FileOutputStream fileOutput = new FileOutputStream(arguments[1])) {
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
            Emitter emitter = new Emitter();
            String output = emitter.emit(astTree);
            bufferedOutput.write(output.getBytes("UTF-8"));
            bufferedOutput.flush();
            fileOutput.flush();
        }
    }
}
