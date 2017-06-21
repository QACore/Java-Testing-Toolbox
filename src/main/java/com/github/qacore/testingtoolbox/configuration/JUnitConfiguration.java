package com.github.qacore.testingtoolbox.configuration;

import java.util.HashMap;
import java.util.Map;

import com.github.qacore.testingtoolbox.JavaTestingToolbox;
import com.github.qacore.testingtoolbox.configuration.base.IJUnitConfiguration;

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
 * @see IJUnitConfiguration
 *
 * @since 1.3.0
 *
 */
@ToString
public class JUnitConfiguration implements IJUnitConfiguration {

    private double              parallelTestThreadsPerCore;
    private Map<Object, Object> additionalProperties;

    public JUnitConfiguration() {
        parallelTestThreadsPerCore = Double.parseDouble(System.getProperty(PARALLEL_TEST_THREADS_PER_CORE, "1"));
        additionalProperties = new HashMap<>();
    }

    @Override
    public double getParallelTestThreadsPerCore() {
        return parallelTestThreadsPerCore;
    }

    public void setParallelTestThreadsPerCore(double parallelTestThreadsPerCore) {
        this.parallelTestThreadsPerCore = parallelTestThreadsPerCore;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Object, Object> getAdditionalProperties() {
        return additionalProperties;
    }

}
