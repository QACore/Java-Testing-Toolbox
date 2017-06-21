package com.github.qacore.testingtoolbox.configuration;

import java.util.HashMap;
import java.util.Map;

import lombok.ToString;

/**
 * This class contains the Selenium configuration.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 */
@ToString
public class SeleniumConfiguration implements HasAdditionalProperties {

    private Map<Object, Object> additionalProperties;

    public SeleniumConfiguration() {
        additionalProperties = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Object, Object> getAdditionalProperties() {
        return additionalProperties;
    }

}
