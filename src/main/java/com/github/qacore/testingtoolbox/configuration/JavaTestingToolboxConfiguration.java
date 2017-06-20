package com.github.qacore.testingtoolbox.configuration;

import com.github.qacore.testingtoolbox.JavaTestingToolbox;
import com.github.qacore.testingtoolbox.configuration.base.IJUnitConfiguration;
import com.github.qacore.testingtoolbox.configuration.base.IJavaTestingToolboxConfiguration;

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
public class JavaTestingToolboxConfiguration implements IJavaTestingToolboxConfiguration {

    private IJUnitConfiguration junit;

    public JavaTestingToolboxConfiguration() {
        junit = new JUnitConfiguration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IJUnitConfiguration junit() {
        return junit;
    }

}
