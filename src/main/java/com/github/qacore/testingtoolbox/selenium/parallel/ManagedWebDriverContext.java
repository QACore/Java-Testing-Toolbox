package com.github.qacore.testingtoolbox.selenium.parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qacore.testingtoolbox.managers.WebDriverManager;

/**
 * Managed {@link WebDriver} parallel context.
 * <p>
 * The default context is {@link WebDriverManager#getDriverContext()}.
 * </p>
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 * @see WebDriverManager
 *
 * @since 1.2.0
 *
 */
public class ManagedWebDriverContext implements WrapsDriver {

    private WrapsDriver driverContext;

    public ManagedWebDriverContext(WrapsDriver driverContext) {
        if (driverContext == null) {
            this.driverContext = WebDriverManager.getDriverContext();
        } else {
            this.driverContext = driverContext;
        }
    }

    public ManagedWebDriverContext(WebDriver webDriver) {
        if (webDriver == null) {
            this.driverContext = WebDriverManager.getDriverContext();
        } else {
            this.driverContext = new WrapsDriver() {

                @Override
                public WebDriver getWrappedDriver() {
                    return webDriver;
                }

            };
        }
    }

    public ManagedWebDriverContext() {
        this.driverContext = WebDriverManager.getDriverContext();
    }

    @Override
    public WebDriver getWrappedDriver() {
        return driverContext.getWrappedDriver();
    }

    protected WrapsDriver getDriverContext() {
        return driverContext;
    }

    protected void setDriverContext(WrapsDriver driverContext) {
        this.driverContext = driverContext;
    }

    @Override
    public String toString() {
        return "ManagedWebDriverContext [driverContext=" + driverContext + "]";
    }

}
