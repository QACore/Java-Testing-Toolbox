package com.github.qacore.testingtoolbox.configuration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;

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

    private ChromeConfiguration           chromeConfiguration;
    private EdgeConfiguration             edgeConfiguration;
    private FirefoxConfiguration          firefoxConfiguration;
    private HtmlUnitConfiguration         htmlUnitConfiguration;
    private InternetExplorerConfiguration internetExplorerConfiguration;
    private OperaConfiguration            operaConfiguration;
    private PhantomJSConfiguration        phantomJSConfiguration;
    private SafariConfiguration           safariConfiguration;

    public SeleniumConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);

        chromeConfiguration = new ChromeConfiguration();
        edgeConfiguration = new EdgeConfiguration();
        firefoxConfiguration = new FirefoxConfiguration();
        htmlUnitConfiguration = new HtmlUnitConfiguration();
        internetExplorerConfiguration = new InternetExplorerConfiguration();
        operaConfiguration = new OperaConfiguration();
        phantomJSConfiguration = new PhantomJSConfiguration();
        safariConfiguration = new SafariConfiguration();
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
        return chromeConfiguration;
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
        if (configuration == null) {
            chromeConfiguration = new ChromeConfiguration();
        } else {
            chromeConfiguration = configuration;
        }

        return this;
    }

    /**
     * Get the default {@link EdgeDriver} configuration.
     * 
     * @return The default {@link EdgeDriver} configuration.
     */
    public EdgeConfiguration edge() {
        return edgeConfiguration;
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
        if (configuration == null) {
            edgeConfiguration = new EdgeConfiguration();
        } else {
            edgeConfiguration = configuration;
        }

        return this;
    }

    /**
     * Get the default {@link FirefoxDriver} configuration.
     * 
     * @return The default {@link FirefoxDriver} configuration.
     */
    public FirefoxConfiguration firefox() {
        return firefoxConfiguration;
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
        if (configuration == null) {
            firefoxConfiguration = new FirefoxConfiguration();
        } else {
            firefoxConfiguration = configuration;
        }

        return this;
    }

    /**
     * Get the default {@link HtmlUnitDriver} configuration.
     * 
     * @return The default {@link HtmlUnitDriver} configuration.
     */
    public HtmlUnitConfiguration htmlUnit() {
        return htmlUnitConfiguration;
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
        if (configuration == null) {
            htmlUnitConfiguration = new HtmlUnitConfiguration();
        } else {
            htmlUnitConfiguration = configuration;
        }

        return this;
    }

    /**
     * Get the default {@link InternetExplorerDriver} configuration.
     * 
     * @return The default {@link InternetExplorerDriver} configuration.
     */
    public InternetExplorerConfiguration ie() {
        return internetExplorerConfiguration;
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
        if (configuration == null) {
            internetExplorerConfiguration = new InternetExplorerConfiguration();
        } else {
            internetExplorerConfiguration = configuration;
        }

        return this;
    }

    /**
     * Get the default {@link OperaDriver} configuration.
     * 
     * @return The default {@link OperaDriver} configuration.
     */
    public OperaConfiguration opera() {
        return operaConfiguration;
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
        if (configuration == null) {
            operaConfiguration = new OperaConfiguration();
        } else {
            operaConfiguration = configuration;
        }

        return this;
    }

    /**
     * Get the default {@link PhantomJSDriver} configuration.
     * 
     * @return The default {@link PhantomJSDriver} configuration.
     */
    public PhantomJSConfiguration phantomJS() {
        return phantomJSConfiguration;
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
        if (configuration == null) {
            phantomJSConfiguration = new PhantomJSConfiguration();
        } else {
            phantomJSConfiguration = configuration;
        }

        return this;
    }

    /**
     * Get the default {@link SafariDriver} configuration.
     * 
     * @return The default {@link SafariDriver} configuration.
     */
    public SafariConfiguration safari() {
        return safariConfiguration;
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
        if (configuration == null) {
            safariConfiguration = new SafariConfiguration();
        } else {
            safariConfiguration = configuration;
        }

        return this;
    }

}
