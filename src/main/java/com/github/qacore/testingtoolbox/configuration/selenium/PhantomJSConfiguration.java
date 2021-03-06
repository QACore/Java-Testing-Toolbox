package com.github.qacore.testingtoolbox.configuration.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;

/**
 * This class contains the default {@link PhantomJSDriver} configuration.
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
public class PhantomJSConfiguration extends AbstractWebDriverConfiguration<PhantomJSConfiguration, PhantomJSDriver> {

    public PhantomJSConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);
    }

    public PhantomJSConfiguration() {
        this(new HashMap<>());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public PhantomJSDriver start(Capabilities other) {
        Capabilities capabilities = this.mergeCapabilities(other);

        if (capabilities == null) {
            return new PhantomJSDriver();
        }

        return new PhantomJSDriver(capabilities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPathProperty() {
        return PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY;
    }

}
