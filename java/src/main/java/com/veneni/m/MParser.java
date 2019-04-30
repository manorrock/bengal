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
        MCharacterTransformer characterTransformer = new MCharacterTransformer();
        result = characterTransformer.transform((List) result);
        MStringTransformer stringTransformer = new MStringTransformer();
        result = stringTransformer.transform((List) result);
        MKeywordTransformer objectKeywordTransformer = new MKeywordTransformer("object");
        result = objectKeywordTransformer.transform((List) result);
        MKeywordTransformer methodKeywordTransformer = new MKeywordTransformer("method");
        result = methodKeywordTransformer.transform((List) result);
        MKeywordTransformer ifKeywordTransformer = new MKeywordTransformer("if");
        result = ifKeywordTransformer.transform((List) result);
        MKeywordTransformer thenKeywordTransformer = new MKeywordTransformer("then");
        result = thenKeywordTransformer.transform((List) result);
        MKeywordTransformer elseKeywordTransformer = new MKeywordTransformer("else");
        result = elseKeywordTransformer.transform((List) result);
        MKeywordTransformer whileKeywordTransformer = new MKeywordTransformer("while");
        result = whileKeywordTransformer.transform((List) result);
        MKeywordTransformer doKeywordTransformer = new MKeywordTransformer("do");
        result = doKeywordTransformer.transform((List) result);
        MKeywordTransformer forKeywordTransformer = new MKeywordTransformer("for");
        result = forKeywordTransformer.transform((List) result);
        MKeywordTransformer nativeKeywordTransformer = new MKeywordTransformer("native");
        result = nativeKeywordTransformer.transform((List) result);
        return result;
    }
}
