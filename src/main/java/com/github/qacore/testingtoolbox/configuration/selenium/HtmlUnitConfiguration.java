package com.github.qacore.testingtoolbox.configuration.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.github.qacore.testingtoolbox.selenium.parallel.WebDriverManager;

/**
 * This class contains the default {@link HtmlUnitDriver} configuration.
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
public class HtmlUnitConfiguration extends AbstractWebDriverConfiguration<HtmlUnitConfiguration, HtmlUnitDriver> {

    public HtmlUnitConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);
    }

    public HtmlUnitConfiguration() {
        this(new HashMap<>());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public HtmlUnitDriver start(boolean managed, Capabilities other) {
        Capabilities capabilities = this.mergeCapabilities(other, null);
        HtmlUnitDriver driver;
        
        if (capabilities == null) {
            driver = new HtmlUnitDriver();
        } else {
            driver = new HtmlUnitDriver(capabilities);
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
        return "webdriver.htmlunit.driver";
    }

}
