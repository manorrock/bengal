/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The MParser.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MParser {
    
    /**
     * Main method.
     * 
     * @param arguments the arguments.
     * @throws Exception when an error occurs.
     */
    public static void main(String[] arguments) throws Exception {
        MParser parser = new MParser();
        parser.parse(arguments[0]);
    }
    
    /**
     * Parse.
     * 
     * @param filename the filename.
     * @return the output.
     * @throws Exception when an error occurs.
     */
    public Object parse(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList list = new ArrayList();
        int read = reader.read();
        while(read != -1) {
            list.add((char) read);
            read = reader.read();
        }
        return parse(list);
    }

    /**
     * Parse.
     * 
     * @param input the input list.
     * @return the output.
     */
    public Object parse(List<Object> input) {
        Object result;
        MCommentTransformer commentTransformer = new MCommentTransformer();
        result = commentTransformer.transform(input);
        MStringTransformer stringTransformer = new MStringTransformer();
        result = stringTransformer.transform((List) result);
        return result;
    }
}
