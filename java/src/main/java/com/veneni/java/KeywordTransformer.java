/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The keyword transformer.
 * 
 * <p>
 *  This transformer will take a specific keyword and transform it from its
 *  characters to a Keyword object.
 * </p>
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class KeywordTransformer {
    
    /**
     * Stores the buffer.
     */
    private final StringBuffer buffer;
    
    /**
     * Stores the done boolean
     */
    private boolean done;
    
    /**
     * Stores the input deque.
     */
    private Deque input;
    
    /**
     * Stores the keyword.
     */
    private final String keyword;
    
    /**
     * Stores the output deque.
     */
    private Deque output;
    
    /**
     * Constructor.
     * 
     * @param keyword the keyword.
     */
    public KeywordTransformer(String keyword) {
        this.buffer = new StringBuffer();
        this.input = new ArrayDeque();
        this.keyword = keyword;
        this.output = new ArrayDeque();
    }
    
    /**
     * Get the input deque.
     * 
     * @return the input.
     */
    public Deque getInput() {
        return input;
    }

    /**
     * Get the output deque.
     * 
     * @return 
     */
    public Deque getOutput() {
        return output;
    }
    
    /**
     * Run method.
     */
    public void run() {
        while(!done) {
            Object item = input.pollLast();
            if (item instanceof Done) {
                done = true;
            } else {
                if (item instanceof Character) {
                    Character character = (Character) item;
                    buffer.append(character.charValue());
                    if (keyword.equals(buffer.toString())) {
                        Keyword result = new Keyword(keyword);
                        buffer.setLength(0);
                        output.addFirst(result);
                    } else if (!keyword.startsWith(buffer.toString())) {
                        String string = buffer.toString();
                        for(int i=0; i<string.length(); i++) {
                            output.addFirst(string.charAt(i));
                        }
                        buffer.setLength(0);
                    }
                } else {
                    output.addFirst(item);
                }
            }
        }
    }
}
