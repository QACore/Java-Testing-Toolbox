package com.github.qacore.testingtoolbox.configuration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.github.qacore.testingtoolbox.configuration.selenium.AbstractWebDriverConfiguration;
import com.github.qacore.testingtoolbox.configuration.selenium.ChromeConfiguration;
import com.github.qacore.testingtoolbox.configuration.selenium.EdgeConfiguration;
import com.github.qacore.testingtoolbox.configuration.selenium.FirefoxConfiguration;
import com.github.qacore.testingtoolbox.configuration.selenium.HtmlUnitConfiguration;
import com.github.qacore.testingtoolbox.configuration.selenium.InternetExplorerConfiguration;
import com.github.qacore.testingtoolbox.configuration.selenium.OperaConfiguration;
import com.github.qacore.testingtoolbox.configuration.selenium.PhantomJSConfiguration;
import com.github.qacore.testingtoolbox.configuration.selenium.SafariConfiguration;

import lombok.ToString;

/**
 * This class contains the Selenium configuration.
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
@ToString
public class SeleniumConfiguration extends AdditionalProperties<Object, Object> {

    private Map<Object, AbstractWebDriverConfiguration<?, ?>> configuration;

    public SeleniumConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);

        configuration = new HashMap<>();
        this.loadDefaultConfiguration();
    }

    public SeleniumConfiguration() {
        this(new HashMap<>());
    }

    /**
     * Get the default {@link ChromeDriver} configuration.
     * 
     * @return The default {@link ChromeDriver} configuration.
     */
    public ChromeConfiguration chrome() {
        return (ChromeConfiguration) this.getConfiguration().get(ChromeDriver.class);
    }

    /**
     * Set the default {@link ChromeDriver} configuration.
     * 
     * @param configuration
     *            The {@link ChromeDriver} configuration.
     * 
     * @return Itself.
     */
    public SeleniumConfiguration chrome(ChromeConfiguration configuration) {
        return this.setDriverConfiguration(ChromeDriver.class, configuration, new ChromeConfiguration());
    }

    /**
     * Get the default {@link EdgeDriver} configuration.
     * 
     * @return The default {@link EdgeDriver} configuration.
     */
    public EdgeConfiguration edge() {
        return (EdgeConfiguration) this.getConfiguration().get(EdgeDriver.class);
    }

    /**
     * Set the default {@link EdgeDriver} configuration.
     * 
     * @param configuration
     *            The {@link EdgeDriver} configuration.
     * 
     * @return Itself.
     */
    public SeleniumConfiguration edge(EdgeConfiguration configuration) {
        return this.setDriverConfiguration(EdgeDriver.class, configuration, new EdgeConfiguration());
    }

    /**
     * Get the default {@link FirefoxDriver} configuration.
     * 
     * @return The default {@link FirefoxDriver} configuration.
     */
    public FirefoxConfiguration firefox() {
        return (FirefoxConfiguration) this.getConfiguration().get(FirefoxDriver.class);
    }

    /**
     * Set the default {@link FirefoxDriver} configuration.
     * 
     * @param configuration
     *            The {@link FirefoxDriver} configuration.
     * 
     * @return Itself.
     */
    public SeleniumConfiguration firefox(FirefoxConfiguration configuration) {
        return this.setDriverConfiguration(FirefoxDriver.class, configuration, new FirefoxConfiguration());
    }

    /**
     * Get the default {@link HtmlUnitDriver} configuration.
     * 
     * @return The default {@link HtmlUnitDriver} configuration.
     */
    public HtmlUnitConfiguration htmlUnit() {
        return (HtmlUnitConfiguration) this.getConfiguration().get(HtmlUnitDriver.class);
    }

    /**
     * Set the default {@link HtmlUnitDriver} configuration.
     * 
     * @param configuration
     *            The {@link HtmlUnitDriver} configuration.
     * 
     * @return Itself.
     */
    public SeleniumConfiguration htmlUnit(HtmlUnitConfiguration configuration) {
        return this.setDriverConfiguration(HtmlUnitDriver.class, configuration, new HtmlUnitConfiguration());
    }

    /**
     * Get the default {@link InternetExplorerDriver} configuration.
     * 
     * @return The default {@link InternetExplorerDriver} configuration.
     */
    public InternetExplorerConfiguration ie() {
        return (InternetExplorerConfiguration) this.getConfiguration().get(InternetExplorerConfiguration.class);
    }

    /**
     * Set the default {@link InternetExplorerDriver} configuration.
     * 
     * @param configuration
     *            The {@link InternetExplorerDriver} configuration.
     * 
     * @return Itself.
     */
    public SeleniumConfiguration ie(InternetExplorerConfiguration configuration) {
        return this.setDriverConfiguration(InternetExplorerConfiguration.class, configuration, new InternetExplorerConfiguration());
    }

    /**
     * Get the default {@link OperaDriver} configuration.
     * 
     * @return The default {@link OperaDriver} configuration.
     */
    public OperaConfiguration opera() {
        return (OperaConfiguration) this.getConfiguration().get(OperaDriver.class);
    }

    /**
     * Set the default {@link InternetExplorerDriver} configuration.
     * 
     * @param configuration
     *            The {@link InternetExplorerDriver} configuration.
     * 
     * @return Itself.
     */
    public SeleniumConfiguration opera(OperaConfiguration configuration) {
        return this.setDriverConfiguration(OperaDriver.class, configuration, new OperaConfiguration());
    }

    /**
     * Get the default {@link PhantomJSDriver} configuration.
     * 
     * @return The default {@link PhantomJSDriver} configuration.
     */
    public PhantomJSConfiguration phantomJS() {
        return (PhantomJSConfiguration) this.getConfiguration().get(PhantomJSDriver.class);
    }

    /**
     * Set the default {@link PhantomJSDriver} configuration.
     * 
     * @param configuration
     *            The {@link PhantomJSDriver} configuration.
     * 
     * @return Itself.
     */
    public SeleniumConfiguration phantomJS(PhantomJSConfiguration configuration) {
        return this.setDriverConfiguration(PhantomJSDriver.class, configuration, new PhantomJSConfiguration());
    }

    /**
     * Get the default {@link SafariDriver} configuration.
     * 
     * @return The default {@link SafariDriver} configuration.
     */
    public SafariConfiguration safari() {
        return (SafariConfiguration) this.getConfiguration().get(SafariDriver.class);
    }

    /**
     * Set the default {@link SafariDriver} configuration.
     * 
     * @param configuration
     *            The {@link SafariDriver} configuration.
     * 
     * @return Itself.
     */
    public SeleniumConfiguration safari(SafariConfiguration configuration) {
        return this.setDriverConfiguration(SafariDriver.class, configuration, new SafariConfiguration());
    }

    /**
     * Load the default configuration. It will not erase previous non-default configurations.
     * 
     * @return Itself.
     */
    public SeleniumConfiguration loadDefaultConfiguration() {
        this.getConfiguration().put(ChromeDriver.class, new ChromeConfiguration());
        this.getConfiguration().put(EdgeDriver.class, new EdgeConfiguration());
        this.getConfiguration().put(FirefoxDriver.class, new FirefoxConfiguration());
        this.getConfiguration().put(HtmlUnitConfiguration.class, new HtmlUnitConfiguration());
        this.getConfiguration().put(InternetExplorerConfiguration.class, new InternetExplorerConfiguration());
        this.getConfiguration().put(OperaConfiguration.class, new OperaConfiguration());
        this.getConfiguration().put(PhantomJSConfiguration.class, new PhantomJSConfiguration());
        this.getConfiguration().put(SafariDriver.class, new SafariConfiguration());

        return this;
    }

    /**
     * Get all the {@link WebDriver} configuration.
     * 
     * @return All the {@link WebDriver} configuration.
     */
    public Map<Object, AbstractWebDriverConfiguration<?, ?>> getConfiguration() {
        return configuration;
    }

    /**
     * Set the {@link WebDriver} configuration.
     * 
     * @param configuration
     *            The {@link WebDriver} configuration.
     * 
     * @return Itself.
     */
    public SeleniumConfiguration setConfiguration(Map<Object, AbstractWebDriverConfiguration<?, ?>> configuration) {
        if (configuration == null) {
            this.loadDefaultConfiguration();
        } else {
            this.configuration = configuration;
        }

        return this;
    }

    /**
     * Set driver configuration.
     * 
     * @param key
     *            The type of keys maintained by this map.
     * 
     * @param configuration
     *            The new configuration.
     * 
     * @param defaultConfiguration
     *            If {@code configuration} is null, the new configuration will be default.
     * 
     * @param <C>
     *            The configuration type (itself).
     * 
     * @param <T>
     *            The webdriver type.
     * 
     * @return Itself.
     */
    protected <C extends AbstractWebDriverConfiguration<C, T>, T extends WebDriver> SeleniumConfiguration setDriverConfiguration(Object key, C configuration, C defaultConfiguration) {
        this.getConfiguration().put(key, configuration == null ? defaultConfiguration : configuration);

        return this;
    }

}
