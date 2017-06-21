package com.github.qacore.testingtoolbox.configuration;

import java.util.HashMap;
import java.util.Map;

import com.github.qacore.testingtoolbox.JavaTestingToolbox;

import lombok.ToString;

/**
 * This class contains the {@link JavaTestingToolbox#getConfiguration() Java Testing Toolbox configuration}.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 * @see JavaTestingToolbox#getConfiguration()
 *
 * @since 1.3.0
 *
 */
@ToString
public class JavaTestingToolboxConfiguration implements HasAdditionalProperties {

    private JUnitConfiguration    junit;
    private SeleniumConfiguration selenium;
    private Map<Object, Object>   additionalProperties;

    public JavaTestingToolboxConfiguration() {
        junit = new JUnitConfiguration();
        selenium = new SeleniumConfiguration();
        additionalProperties = new HashMap<>();
    }

    /**
     * Get the current JUnit configuration.
     * 
     * @return The JUnit configuration.
     */
    public JUnitConfiguration junit() {
        return junit;
    }

    /**
     * Get the current Selenium configuration.
     * 
     * @return The Selenium configuration.
     */
    public SeleniumConfiguration selenium() {
        return selenium;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Object, Object> getAdditionalProperties() {
        return additionalProperties;
    }

}
