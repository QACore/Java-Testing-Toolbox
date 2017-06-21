package com.github.qacore.testingtoolbox.configuration.base;

import java.util.Map;

import com.github.qacore.testingtoolbox.JavaTestingToolbox;
import com.github.qacore.testingtoolbox.configuration.JUnitConfiguration;
import com.github.qacore.testingtoolbox.configuration.JavaTestingToolboxConfiguration;

/**
 * This interface indicates that this class contains the JUnit configuration.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 * @see JavaTestingToolbox#getConfiguration()
 * @see JavaTestingToolboxConfiguration#junit()
 * @see JUnitConfiguration
 * 
 * @since 1.3.0
 *
 */
public interface IJUnitConfiguration extends HasAdditionalProperties {

    public static final String PARALLEL_TEST_THREADS_PER_CORE = "toolbox.junit.parallelTestThreadsPerCore";

    public double getParallelTestThreadsPerCore();

    /**
     * Get total test threads.
     * 
     * @return The total test threads based on {@link #getParallelTestThreadsPerCore()} * available processors.
     */
    public default int getTotalTestThreads() {
        double parallelTestThreadsPerCore = this.getParallelTestThreadsPerCore() * Runtime.getRuntime().availableProcessors();

        if (parallelTestThreadsPerCore - (int) parallelTestThreadsPerCore >= 0.5) {
            parallelTestThreadsPerCore++;
        }

        if (parallelTestThreadsPerCore < 1) {
            return 1;
        }

        return (int) parallelTestThreadsPerCore;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Object, Object> getAdditionalProperties();

}
