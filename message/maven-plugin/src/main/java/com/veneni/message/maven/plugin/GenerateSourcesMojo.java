/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.maven.plugin;

import java.io.File;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * A goal that takes your Veneni Message sources and translates them into Java.
 */
@Mojo(name = "generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class GenerateSourcesMojo extends AbstractMojo {

    /**
     * Stores the output directory.
     */
    @Parameter(
            defaultValue = "${project.build.directory}/generated-sources/vmesg",
            property = "outputDir",
            required = true)
    private File outputDirectory;

    /**
     * Execute the Mojo.
     *
     * @throws MojoExecutionException when a serious error occurs.
     */
    @Override
    public void execute() throws MojoExecutionException {
        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }
    }
}
