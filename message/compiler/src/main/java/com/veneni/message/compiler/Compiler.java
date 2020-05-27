/*
 * Copyright (c) 2002-2020 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.compiler;

/**
 * The Veneni Message compiler.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
class Compiler {

    /**
     * Stores the current class count.
     */
    private int index = 1;

    /**
     * Compile the input.
     *
     * @param input the input.
     * @return the output.
     */
    public String compile(String input) {
        String output;
        Parser parser = new Parser();
        Object parsed = parser.parse(input);
        String result = compileParsed(parsed);
        if (result != null) {
            output = result;
        } else {
            output = input;
        }
        return output;
    }

    /**
     * Compile the parsed tree.
     *
     * @param parsed the parsed tree.
     * @return the result of the compilation.
     */
    private String compileParsed(Object parsed) {
        String output = null;
        if (parsed instanceof ParsedBoolean) {
            ParsedBoolean parsedBoolean = (ParsedBoolean) parsed;
            output = compileBoolean(parsedBoolean);
        } else if (parsed instanceof ParsedMethod) {
            ParsedMethod parsedMethod = (ParsedMethod) parsed;
            output = compileMethod(parsedMethod);
        } else if (parsed instanceof ParsedObject) {
            ParsedObject parsedObject = (ParsedObject) parsed;
            output = compileObject(parsedObject);
        } else if (parsed instanceof ParsedNil) {
            ParsedNil pn = (ParsedNil) parsed;
            output = compileNil(pn);
        }
        return output;
    }

    /**
     * Compile the parsed boolean to Java.
     * 
     * @param parsedBoolean the parsed boolean.
     */
    private String compileBoolean(ParsedBoolean parsedBoolean) {
        return Boolean.toString(parsedBoolean.getBoolean());
    }
    
    /**
     * Compile the parsed method to Java.
     * 
     * @param parsedMethod the parsed method.
     */
    private String compileMethod(ParsedMethod parsedMethod) {
        StringBuilder output = new StringBuilder();
        output.append("private Object ").append(parsedMethod.getName()).append("() {\n");
        output.append("}");
        return output.toString();
    }
    
    /**
     * Compile the parsed nil to Java.
     * 
     * @param parsedNil the parsed nil.
     * @return the Java output.
     */
    private String compileNil(ParsedNil parsedNil) {
        StringBuilder output = new StringBuilder();
        output.append("class0.INSTANCE");
        return output.toString();
    }
    

    /**
     * Compile the parsed object to Java.
     * 
     * @param parsedObject the parsed object.
     */
    private String compileObject(ParsedObject parsedObject) {
        StringBuilder output = new StringBuilder();
        output.append("public class ").append("class").append(index++).append(" {\n");
        output.append("public static final String VENENI_OBJECT_NAME = \"").append(parsedObject.getName()).append("\";\n");
        output.append("}");
        return output.toString();
    }
}
