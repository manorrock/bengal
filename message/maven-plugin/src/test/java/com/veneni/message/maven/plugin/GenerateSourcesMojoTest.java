/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.maven.plugin;

import java.io.File;
import org.apache.maven.plugin.testing.MojoRule;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;

/**
 * The JUnit test for the GenerateSourcesMojo class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class GenerateSourcesMojoTest {

    /**
     * Defines the Mojo rule.
     */
    @Rule
    public MojoRule rule = new MojoRule() {
        @Override
        protected void before() throws Throwable {
        }

        @Override
        protected void after() {
        }
    };

    /**
     * Test the 'generate-sources' goal.
     * 
     * @throws Exception when a serious error occurs.
     */
    @Test
    public void testGenerateSourcesGoal() throws Exception {
        File pom = new File("target/test-classes/project-to-test");
        assertNotNull(pom);
        assertTrue(pom.exists());

        GenerateSourcesMojo mojo = (GenerateSourcesMojo) rule.lookupConfiguredMojo(pom, "generate-sources");
        assertNotNull(mojo);
        mojo.execute();

        File outputDirectory = (File) rule.getVariableValueFromObject(mojo, "outputDirectory");
        assertNotNull(outputDirectory);
        assertTrue(outputDirectory.exists());
    }
}
