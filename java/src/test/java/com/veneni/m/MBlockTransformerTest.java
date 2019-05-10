/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The JUnit tests for the MBlockTransformer.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MBlockTransformerTest {
    
    /**
     * Test transform method.
     */
    @Test
    public void testTransform() {
        ArrayList input = new ArrayList();
        MBlockTransformer transformer = new MBlockTransformer();
        List result = transformer.transform(input);
        assertNotNull(result);
    }
}
