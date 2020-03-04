/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * The parser.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Parser {

    /**
     * Parse.
     *
     * @param filename the filename.
     * @return the output.
     */
    public Object parseFile(String filename) {
        Object result;
        try {
            String contents = new String(Files.readAllBytes(Paths.get(filename)));
            result =  parse(contents);
        } catch (IOException ioe) {
            result = ioe;
        }
        return result;
    }

    /**
     * Parse the input.
     *
     * @param input the input.
     * @return the output.
     */
    public Object parse(String input) {
        Object result;
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> outputList = new ArrayList<>();
        if (list.size() == 1) {
            result = outputList.get(0);
        } else {
            result = outputList;
        }
        return result;
    }
}
