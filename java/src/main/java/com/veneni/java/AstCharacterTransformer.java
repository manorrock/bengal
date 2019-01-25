/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The character transformer.
 *
 * <p>
 * This transformer will transform characters.
 * </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstCharacterTransformer {

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
     * Stores the output deque.
     */
    private Deque output;

    /**
     * Constructor.
     */
    public AstCharacterTransformer() {
        this.buffer = new StringBuffer();
        this.input = new ArrayDeque();
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
     * @return the output deque.
     */
    public Deque getOutput() {
        return output;
    }

    /**
     * Run method.
     */
    public void run() {
        while (!done) {
            Object item = input.pollLast();
            if (item instanceof Done) {
                done = true;
            } else {
                if (item instanceof Character) {
                    char character = (Character) item;
                    if (buffer.length() > 0 && character != '\'') {
                        buffer.append(character);
                    } else if (buffer.length() > 0 && character == '\'') {
                        AstCharacter astCharacter = new AstCharacter(
                                buffer.toString().substring(1));
                        output.addFirst(astCharacter);
                        buffer.setLength(0);
                    } else if (character == '\'') {
                        buffer.append(character);
                    } else {
                        output.addFirst(character);
                    }
                } else {
                    if (buffer.length() > 0) {
                        for (int i = 0; i < buffer.length(); i++) {
                            output.addFirst(buffer.charAt(i));
                        }
                        buffer.setLength(0);
                    }
                    output.addFirst(item);
                }
            }
        }
        if (buffer.length() > 0) {
            for (int i = 0; i < buffer.length(); i++) {
                output.addFirst(buffer.charAt(i));
            }
        }
        output.addFirst(new Done());
    }
}
