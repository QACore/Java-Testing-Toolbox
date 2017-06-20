package com.github.qacore.testingtoolbox.configuration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.qacore.testingtoolbox.junit.runners.Parallel;

@RunWith(Parallel.class)
public class JUnitConfigurationTest {

    @Test
    public void getAndSetParallelTestThreadsPerCore() {
        JUnitConfiguration junitConfiguration = new JUnitConfiguration();

        junitConfiguration.setParallelTestThreadsPerCore(-1);
        assertEquals(-1, junitConfiguration.getParallelTestThreadsPerCore(), 0D);

        junitConfiguration.setParallelTestThreadsPerCore(-0.5);
        assertEquals(-0.5, junitConfiguration.getParallelTestThreadsPerCore(), 0D);

        junitConfiguration.setParallelTestThreadsPerCore(0);
        assertEquals(0, junitConfiguration.getParallelTestThreadsPerCore(), 0D);

        junitConfiguration.setParallelTestThreadsPerCore(0.5);
        assertEquals(0.5, junitConfiguration.getParallelTestThreadsPerCore(), 0D);

        junitConfiguration.setParallelTestThreadsPerCore(1);
        assertEquals(1, junitConfiguration.getParallelTestThreadsPerCore(), 0D);
    }

    @Test
    public void toStringTest() {
        JUnitConfiguration junitConfiguration = new JUnitConfiguration();

        junitConfiguration.setParallelTestThreadsPerCore(-1);
        assertEquals("JUnitConfiguration [parallelTestThreadsPerCore=-1.0]", junitConfiguration.toString());

        junitConfiguration.setParallelTestThreadsPerCore(0);
        assertEquals("JUnitConfiguration [parallelTestThreadsPerCore=0.0]", junitConfiguration.toString());

        junitConfiguration.setParallelTestThreadsPerCore(1);
        assertEquals("JUnitConfiguration [parallelTestThreadsPerCore=1.0]", junitConfiguration.toString());
    }

}
