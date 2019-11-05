/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.io.File;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * The JUnit tests for the FileTransformer.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class FileTransformerTest {

    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        FileTransformer transformer = new FileTransformer();
        assertEquals("Pass this through", transformer.transform("Pass this through"));
    }

    /**
     * Test transform method.
     */
    @Test
    public void testTransform2() {
        FileTransformer transformer = new FileTransformer();
        List result = (List) transformer.transform(new File("src/test/veneni/m/HelloWorld.m"));
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
