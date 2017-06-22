package com.github.qacore.testingtoolbox.configuration.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import com.github.qacore.testingtoolbox.selenium.parallel.WebDriverManager;

/**
 * This class contains the default {@link InternetExplorerDriver} configuration.
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
public class InternetExplorerConfiguration extends AbstractWebDriverConfiguration<InternetExplorerDriver> {

    public InternetExplorerConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);
    }

    public InternetExplorerConfiguration() {
        this(new HashMap<>());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public InternetExplorerDriver start(boolean managed, Capabilities other) {
        Capabilities capabilities = this.getDefaultCapabilities();
        InternetExplorerDriver driver;

        if (capabilities == null) {
            if (other == null) {
                driver = new InternetExplorerDriver();
            } else {
                driver = new InternetExplorerDriver(other);
            }
        } else {
            if (other == null) {
                driver = new InternetExplorerDriver(capabilities);
            } else {
                driver = new InternetExplorerDriver(capabilities.merge(other));
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
        return InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY;
    }

}