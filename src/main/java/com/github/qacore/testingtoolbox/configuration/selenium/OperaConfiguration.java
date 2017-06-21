package com.github.qacore.testingtoolbox.configuration.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;

import com.github.qacore.testingtoolbox.selenium.parallel.WebDriverManager;

/**
 * This class contains the default {@link OperaDriver} configuration.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @since 1.4.0
 *
 */
public class OperaConfiguration extends AbstractWebDriverConfiguration<OperaDriver> {

    public OperaConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);
    }

    public OperaConfiguration() {
        this(new HashMap<>());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public OperaDriver start(boolean managed, Capabilities other) {
        Capabilities capabilities = this.getDefaultCapabilities();
        OperaDriver driver;

        if (capabilities == null) {
            if (other == null) {
                driver = new OperaDriver();
            } else {
                driver = new OperaDriver(other);
            }
        } else {
            if (other == null) {
                driver = new OperaDriver(capabilities);
            } else {
                driver = new OperaDriver(capabilities.merge(other));
            }
        }

        if (managed) {
            WebDriverManager.setDriver(driver);
        }

        return driver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPathProperty() {
        return OperaDriverService.OPERA_DRIVER_EXE_PROPERTY;
    }

}
