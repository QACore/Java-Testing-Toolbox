package com.github.qacore.testingtoolbox.configuration;

import java.util.HashMap;
import java.util.Map;

import com.github.qacore.testingtoolbox.JavaTestingToolbox;
import com.github.qacore.testingtoolbox.configuration.base.IJUnitConfiguration;
import com.github.qacore.testingtoolbox.configuration.base.IJavaTestingToolboxConfiguration;

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
 * @see IJavaTestingToolboxConfiguration
 *
 * @since 1.3.0
 *
 */
@ToString
public class JavaTestingToolboxConfiguration implements IJavaTestingToolboxConfiguration {

    private IJUnitConfiguration junit;
    private Map<Object, Object> additionalProperties;

    public JavaTestingToolboxConfiguration() {
        junit = new JUnitConfiguration();
        additionalProperties = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IJUnitConfiguration junit() {
        return junit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Object, Object> getAdditionalProperties() {
        return additionalProperties;
    }

}
