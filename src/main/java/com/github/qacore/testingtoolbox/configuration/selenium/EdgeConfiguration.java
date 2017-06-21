package com.github.qacore.testingtoolbox.configuration.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

import com.github.qacore.testingtoolbox.selenium.parallel.WebDriverManager;

/**
 * This class contains the default {@link EdgeDriver} configuration.
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
public class EdgeConfiguration extends AbstractWebDriverConfiguration<EdgeDriver> {

    public EdgeConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);
    }

    public EdgeConfiguration() {
        this(new HashMap<>());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EdgeDriver start(boolean managed, Capabilities other) {
        Capabilities capabilities = this.getDefaultCapabilities();
        EdgeDriver driver;

        if (capabilities == null) {
            if (other == null) {
                driver = new EdgeDriver();
            } else {
                driver = new EdgeDriver(other);
            }
        } else {
            if (other == null) {
                driver = new EdgeDriver(capabilities);
            } else {
                driver = new EdgeDriver(capabilities.merge(other));
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
        return EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY;
    }

}
