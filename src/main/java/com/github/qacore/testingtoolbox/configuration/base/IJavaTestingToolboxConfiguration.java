package com.github.qacore.testingtoolbox.configuration.base;

import com.github.qacore.testingtoolbox.JavaTestingToolbox;
import com.github.qacore.testingtoolbox.configuration.JavaTestingToolboxConfiguration;

/**
 * This interface indicates that this class contains the {@link JavaTestingToolbox#getConfiguration() Java Testing Toolbox configuration}.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @see JavaTestingToolbox#getConfiguration()
 * @see JavaTestingToolboxConfiguration
 * 
 * @since 1.3.0
 *
 */
public interface IJavaTestingToolboxConfiguration {

    /**
     * Get the current JUnit configuration.
     * 
     * @return The JUnit configuration.
     */
    public IJUnitConfiguration junit();

}
