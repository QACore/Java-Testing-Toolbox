package com.github.qacore.testingtoolbox.configuration.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import com.github.qacore.testingtoolbox.selenium.parallel.WebDriverManager;

/**
 * This class contains the default {@link FirefoxDriver} configuration.
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
public class FirefoxConfiguration extends AbstractWebDriverConfiguration<FirefoxConfiguration, FirefoxDriver> {

    public FirefoxConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);
    }

    public FirefoxConfiguration() {
        this(new HashMap<>());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public FirefoxDriver start(boolean managed, Capabilities other) {
        Capabilities capabilities = this.mergeCapabilities(other, null);
        FirefoxDriver driver;
        
        if (capabilities == null) {
            driver = new FirefoxDriver();
        } else {
            driver = new FirefoxDriver(capabilities);
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
        return GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY;
    }

}
