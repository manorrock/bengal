/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A transformer that transforms a File instance to a list of Char instances.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class FileTransformer {

    /**
     * Transform.
     *
     * @param input the input.
     * @return the output.
     */
    public Object transform(Object input) {
        Object result = input;
        if (input instanceof File) {
            File file = (File) input;
            ArrayList characters = new ArrayList();
            try (FileInputStream fileInput = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int character = fileInput.read(buffer);
                while (character != -1) {
                    characters.add(new Char((char) character));
                    character = fileInput.read(buffer);
                }
                result = characters;
            } catch (IOException ioe) {
                result = null;
            }
        }
        return result;
    }
}
