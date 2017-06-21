package com.github.qacore.testingtoolbox.configuration;

import java.util.Map;

/**
 * Used by classes to indicate that they have additional properties. This can be used for run-time detection of features.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 * @since 1.3.1
 *
 */
public interface HasAdditionalProperties {

    /**
     * Get additional properties.
     * 
     * @return A map of additional properties.
     */
    public Map<Object, Object> getAdditionalProperties();

}
