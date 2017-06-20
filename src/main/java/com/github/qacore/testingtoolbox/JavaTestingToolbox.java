package com.github.qacore.testingtoolbox;

import com.github.qacore.testingtoolbox.configuration.JavaTestingToolboxConfiguration;
import com.github.qacore.testingtoolbox.configuration.base.IJavaTestingToolboxConfiguration;

/**
 * The main class for ecosystem configuration.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 * @see IJavaTestingToolboxConfiguration
 *
 * @since 1.3.0
 *
 */
public final class JavaTestingToolbox {

    private static IJavaTestingToolboxConfiguration configuration;

    static {
        configuration = new JavaTestingToolboxConfiguration();
    }

    /**
     * Get the global Java Testing Toolbox configuration.
     * 
     * @return The global Java Testing Toolbox configuration.
     * 
     */
    public static IJavaTestingToolboxConfiguration getConfiguration() {
        return configuration;
    }

    private JavaTestingToolbox() {

    }

}
