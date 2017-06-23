package com.github.qacore.testingtoolbox.configuration.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

/**
 * This class contains the default {@link ChromeDriver} configuration.
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
public class ChromeConfiguration extends AbstractWebDriverConfiguration<ChromeConfiguration, ChromeDriver> {

    public ChromeConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);
    }

    public ChromeConfiguration() {
        this(new HashMap<>());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChromeDriver start(Capabilities other) {
        Capabilities capabilities = this.mergeCapabilities(other);

        if (capabilities == null) {
            return new ChromeDriver();
        }

        return new ChromeDriver(capabilities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPathProperty() {
        return ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;
    }

}
