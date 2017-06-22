package com.github.qacore.testingtoolbox.configuration.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import com.github.qacore.testingtoolbox.configuration.AdditionalProperties;
import com.github.qacore.testingtoolbox.selenium.parallel.WebDriverManager;

/**
 * This class contains the abstract {@link WebDriver} configuration.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @param <I>
 *            Itself class for fluent pattern.
 * 
 * @param <T>
 *            The driver to be configured.
 * 
 * @since 1.4.0
 *
 */
public abstract class AbstractWebDriverConfiguration<I extends AbstractWebDriverConfiguration<I, T>, T extends WebDriver> extends AdditionalProperties<Object, Object> {

    private Capabilities defaultCapabilities;

    public AbstractWebDriverConfiguration(Map<Object, Object> additionalProperties) {
        super(additionalProperties);
    }

    public AbstractWebDriverConfiguration() {
        this(new HashMap<>());
    }

    /**
     * Start new {@link WebDriver} with the default merged capabilities and other capabilities.
     * 
     * @param managed
     *            If {@code true}, will be managed by the {@link WebDriverManager}. Otherwise, false.
     * 
     * @param other
     *            The other capabilities. (Null is accepted)
     * 
     * @return The new {@link WebDriver} with the default merged capabilities and other capabilities.
     */
    public abstract T start(boolean managed, Capabilities other);

    /**
     * Start new {@link WebDriver} with default capabilities.
     * 
     * @param managed
     *            If {@code true}, will be managed by the {@link WebDriverManager}. Otherwise, false.
     * 
     * @return The new {@link WebDriver} with default capabilities.
     */
    public T start(boolean managed) {
        return this.start(managed, null);
    }

    /**
     * Get the default driver capabilities.
     * 
     * @return The default driver capabilities.
     */
    public Capabilities getDefaultCapabilities() {
        return defaultCapabilities;
    }

    /**
     * Set the default driver capabilities.
     * 
     * @param defaultCapabilities
     *            The default driver capabilities.
     * 
     * @return Itself.
     */
    public I setDefaultCapabilities(Capabilities defaultCapabilities) {
        this.defaultCapabilities = defaultCapabilities;

        return this.itself();
    }

    /**
     * Get the driver's path indicated by the path property.
     * 
     * @return The driver's path.
     */
    public String getPath() {
        return System.getProperty(this.getPathProperty());
    }

    /**
     * Set the driver's path indicated by the path property.
     * 
     * @param path
     *            The driver's path.
     * 
     * @return Itself.
     */
    public I setPath(String path) {
        if (path == null) {
            System.clearProperty(this.getPathProperty());
        } else {
            System.setProperty(this.getPathProperty(), path);
        }

        return this.itself();
    }

    /**
     * Get the driver's path property.
     * 
     * @return The driver's path property.
     */
    public abstract String getPathProperty();

    /**
     * Merge two {@link Capabilities} (default capabilities and other) together and return the union of the two as a new {@link Capabilities} instance. Capabilities from {@code other} will override those in {@code this}.
     * 
     * @param other
     *            Other capabilities.
     * 
     * @param defaultIfNull
     *            Default capabilities if null return.
     * 
     * @return The merged capabilities.
     */
    protected Capabilities mergeCapabilities(Capabilities other, Capabilities defaultIfNull) {
        Capabilities capabilities = this.getDefaultCapabilities();

        if (capabilities == null) {
            if (other != null) {
                return other;
            }
        } else {
            if (other == null) {
                return capabilities;
            } else {
                return capabilities.merge(other);
            }
        }

        return defaultIfNull;
    }

    /**
     * Get itself for fluent pattern.
     * 
     * @return Itself for fluent pattern.
     */
    @SuppressWarnings("unchecked")
    protected I itself() {
        return (I) this;
    }

}
