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
 * This transformer will take whitespace and transform it into Whitespace
 * objects.
 * </p>
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class WhitespaceTransformer {

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
    private final Deque input;

    /**
     * Stores the output deque.
     */
    private final Deque output;

    /**
     * Constructor.
     */
    public WhitespaceTransformer() {
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
     * @return
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
                    Character character = (Character) item;
                    if (!Character.isWhitespace(character)) {
                        output.addFirst(character);
                    } else {
                        if (buffer.length() > 0) {
                            Whitespace whitespace = new Whitespace(buffer.toString());
                            output.addFirst(whitespace);
                            buffer.setLength(0);
                        } else {
                            buffer.append(character);
                        }
                    }
                } else {
                    output.addFirst(item);
                }
            }
        }
        if (buffer.length() > 0) {
            Whitespace whitespace = new Whitespace(buffer.toString());
            output.addFirst(whitespace);
        }
        output.addFirst(new Done());
    }
}
