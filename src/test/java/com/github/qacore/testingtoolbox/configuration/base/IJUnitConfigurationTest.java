package com.github.qacore.testingtoolbox.configuration.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IJUnitConfigurationTest {

    @Test
    public void getTotalTestThreadsTest() {
        IJUnitConfiguration configuration = new IJUnitConfiguration() {

            @Override
            public double getParallelTestThreadsPerCore() {
                return 0;
            }

        };

        assertEquals(1, configuration.getTotalTestThreads());

        configuration = new IJUnitConfiguration() {

            @Override
            public double getParallelTestThreadsPerCore() {
                // 0.5 total test threads
                return 1 / (Runtime.getRuntime().availableProcessors() / 0.5);
            }

        };

        assertEquals(1, configuration.getTotalTestThreads());
    }

}
