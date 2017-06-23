package com.github.qacore.testingtoolbox.configuration.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.safari.SafariDriver;

/**
 * This class contains the default {@link SafariDriver} configuration.
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
public class SafariConfiguration extends AbstractWebDriverConfiguration<SafariConfiguration, SafariDriver> {

    public SafariConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);
    }

    public SafariConfiguration() {
        this(new HashMap<>());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SafariDriver start(Capabilities other) {
        Capabilities capabilities = this.mergeCapabilities(other);

        if (capabilities == null) {
            return new SafariDriver();
        }

        return new SafariDriver(capabilities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPathProperty() {
        return "webdriver.safari.driver";
    }

}
