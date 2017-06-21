package com.github.qacore.testingtoolbox.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static support.Validations.assertLombokToString;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.qacore.testingtoolbox.junit.runners.Parallel;

@RunWith(Parallel.class)
public class JUnitConfigurationTest {

    @Test
    public void getAndSetParallelTestThreadsPerCoreTest() {
        JUnitConfiguration configuration = new JUnitConfiguration();

        configuration.setParallelTestThreadsPerCore(-1);
        assertEquals(-1, configuration.getParallelTestThreadsPerCore(), 0D);

        configuration.setParallelTestThreadsPerCore(-0.5);
        assertEquals(-0.5, configuration.getParallelTestThreadsPerCore(), 0D);

        configuration.setParallelTestThreadsPerCore(0);
        assertEquals(0, configuration.getParallelTestThreadsPerCore(), 0D);

        configuration.setParallelTestThreadsPerCore(0.5);
        assertEquals(0.5, configuration.getParallelTestThreadsPerCore(), 0D);

        configuration.setParallelTestThreadsPerCore(1);
        assertEquals(1, configuration.getParallelTestThreadsPerCore(), 0D);
    }
    
    @Test
    public void getAdditionalPropertiesTest() {
        JUnitConfiguration configuration = new JUnitConfiguration();
        
        assertNotNull(configuration.getAdditionalProperties());
    }
    
    @Test
    public void toStringTest() {
        assertLombokToString(new JUnitConfiguration());
    }

}
