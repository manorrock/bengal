/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m.java;

import com.veneni.m.MParser;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * Translate Veneni-M to Java.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class JavaCompiler {
    
    /**
     * Execute the compiler.
     * 
     * @param inputFilename the input filename.
     * @param outputFilename the output filename.
     * @throws Exception when an serious error occurs.
     */
    public void execute(String inputFilename, String outputFilename) throws Exception {
        MParser parser = new MParser();
        Object astTree = parser.parse(inputFilename);
        try (FileOutputStream fileOutput = new FileOutputStream(outputFilename)) {
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
            Emitter emitter = new Emitter();
            String output = emitter.emit(astTree);
            bufferedOutput.write(output.getBytes("UTF-8"));
            bufferedOutput.flush();
            fileOutput.flush();
        }
    }
}
