package com.github.qacore.testingtoolbox.configuration;

import java.util.HashMap;
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
 * @param <K>
 *            The type of keys maintained by this map.
 *            
 * @param <V>
 *            The type of mapped values.
 * 
 * @since 1.4.0
 *
 */
public class AdditionalProperties<K, V> {

    private Map<K, V> additionalProperties;

    public AdditionalProperties(Map<K, V> additionalProperties) {
        if (additionalProperties == null) {
            this.additionalProperties = new HashMap<>();
        } else {
            this.additionalProperties = additionalProperties;
        }
    }

    public AdditionalProperties() {
        additionalProperties = new HashMap<>();
    }

    /**
     * Get additional properties.
     * 
     * @return A map of additional properties.
     */
    public Map<K, V> additionalProperties() {
        return additionalProperties;
    }

    /**
     * Set additional properties.
     * 
     * @param additionalProperties
     *            The additional properties.
     * 
     * @return Itself.
     */
    public AdditionalProperties<K, V> additionalProperties(Map<K, V> additionalProperties) {
        if (additionalProperties == null) {
            this.additionalProperties = new HashMap<>();
        } else {
            this.additionalProperties = additionalProperties;
        }

        return this;
    }

    @Override
    public String toString() {
        return "additionalProperties=" + additionalProperties;
    }

}
