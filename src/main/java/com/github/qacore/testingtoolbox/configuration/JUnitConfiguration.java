package com.github.qacore.testingtoolbox.configuration;

import java.util.HashMap;
import java.util.Map;

import com.github.qacore.testingtoolbox.JavaTestingToolbox;

import lombok.ToString;

/**
 * This class contains the JUnit configuration.
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
 *
 * @since 1.3.0
 *
 */
@ToString
public class JUnitConfiguration extends AdditionalProperties<Object, Object> {

    public static final String PARALLEL_TEST_THREADS_PER_CORE = "toolbox.junit.parallelTestThreadsPerCore";

    private double             parallelTestThreadsPerCore;

    public JUnitConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);

        parallelTestThreadsPerCore = Double.parseDouble(System.getProperty(PARALLEL_TEST_THREADS_PER_CORE, "1"));
    }

    public JUnitConfiguration() {
        this(new HashMap<>());
    }

    public double getParallelTestThreadsPerCore() {
        return parallelTestThreadsPerCore;
    }

    public void setParallelTestThreadsPerCore(double parallelTestThreadsPerCore) {
        this.parallelTestThreadsPerCore = parallelTestThreadsPerCore;
    }

    /**
     * Get total test threads.
     * 
     * @return The total test threads based on {@link #getParallelTestThreadsPerCore()} * available processors.
     */
    public int getTotalTestThreads() {
        double parallelTestThreadsPerCore = this.getParallelTestThreadsPerCore() * Runtime.getRuntime().availableProcessors();

        if (parallelTestThreadsPerCore - (int) parallelTestThreadsPerCore >= 0.5) {
            parallelTestThreadsPerCore++;
        }

        if (parallelTestThreadsPerCore < 1) {
            return 1;
        }

        return (int) parallelTestThreadsPerCore;
    }

}
