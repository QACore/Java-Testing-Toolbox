package com.github.qacore.testingtoolbox.configuration;

import java.util.HashMap;
import java.util.Map;

import com.github.qacore.testingtoolbox.JavaTestingToolbox;

import lombok.ToString;

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
 *
 * @since 1.3.0
 *
 */
@ToString
public class JavaTestingToolboxConfiguration extends AdditionalProperties<Object, Object> {

    private JUnitConfiguration    junit;
    private SeleniumConfiguration selenium;

    public JavaTestingToolboxConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);

        this.junit = new JUnitConfiguration();
        this.selenium = new SeleniumConfiguration();
    }

    public JavaTestingToolboxConfiguration() {
        this(new HashMap<>());
    }

    /**
     * Get the current JUnit configuration.
     * 
     * @return The JUnit configuration.
     */
    public JUnitConfiguration junit() {
        return junit;
    }

    /**
     * Set the current JUnit configuration.
     * 
     * @param junit
     *            The JUnit configuration.
     * 
     * @return Itself.
     */
    public JavaTestingToolboxConfiguration junit(JUnitConfiguration junit) {
        if (junit == null) {
            junit = new JUnitConfiguration();
        } else {
            this.junit = junit;
        }

        return this;
    }

    /**
     * Get the current Selenium configuration.
     * 
     * @return The Selenium configuration.
     */
    public SeleniumConfiguration selenium() {
        return selenium;
    }

    /**
     * Set the current Selenium configuration.
     * 
     * @param selenium
     *            The Selenium configuration.
     * 
     * @return Itself.
     */
    public JavaTestingToolboxConfiguration selenium(SeleniumConfiguration selenium) {
        if (selenium == null) {
            selenium = new SeleniumConfiguration();
        } else {
            this.selenium = selenium;
        }

        return this;
    }

}
