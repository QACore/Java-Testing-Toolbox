package com.github.qacore.testingtoolbox.configuration;

import static org.junit.Assert.assertNotNull;
import static support.Validations.assertLombokToString;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.qacore.testingtoolbox.junit.runners.parallel.Parallel;

@RunWith(Parallel.class)
public class JavaTestingToolboxConfigurationTest {

    @Test
    public void junitTest() {
        JavaTestingToolboxConfiguration configuration = new JavaTestingToolboxConfiguration();

        assertNotNull(configuration.junit());
    }

    @Test
    public void getAdditionalPropertiesTest() {
        JavaTestingToolboxConfiguration configuration = new JavaTestingToolboxConfiguration();

        assertNotNull(configuration.additionalProperties());
    }

    @Test
    public void toStringTest() {
        assertLombokToString(new JavaTestingToolboxConfiguration());
    }

}
