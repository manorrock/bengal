/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.parser;

import com.veneni.java.transformer.CharacterTransformer;
import com.veneni.java.transformer.CommentTransformer;
import com.veneni.java.transformer.KeywordTransformer;
import com.veneni.java.transformer.StringTransformer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The Parser.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class Parser {
    
    /**
     * Main method.
     * 
     * @param arguments the arguments.
     * @throws Exception when an error occurs.
     */
    public static void main(String[] arguments) throws Exception {
        Parser parser = new Parser();
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
        CommentTransformer commentTransformer = new CommentTransformer();
        result = commentTransformer.transform(input);
        CharacterTransformer characterTransformer = new CharacterTransformer();
        result = characterTransformer.transform((List) result);
        StringTransformer stringTransformer = new StringTransformer();
        result = stringTransformer.transform((List) result);
        KeywordTransformer objectKeywordTransformer = new KeywordTransformer("object");
        result = objectKeywordTransformer.transform((List) result);
        KeywordTransformer methodKeywordTransformer = new KeywordTransformer("method");
        result = methodKeywordTransformer.transform((List) result);
        KeywordTransformer ifKeywordTransformer = new KeywordTransformer("if");
        result = ifKeywordTransformer.transform((List) result);
        KeywordTransformer thenKeywordTransformer = new KeywordTransformer("then");
        result = thenKeywordTransformer.transform((List) result);
        KeywordTransformer elseKeywordTransformer = new KeywordTransformer("else");
        result = elseKeywordTransformer.transform((List) result);
        return result;
    }
}
