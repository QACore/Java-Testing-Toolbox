package com.github.qacore.testingtoolbox.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

/**
 * Manage {@link WebDriver}, one per {@link Thread} to support parallel testing.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 */
public final class WebDriverManager {

    private static final ThreadLocal<WebDriver> webDriver     = new ThreadLocal<>();
    private static final WrapsDriver            driverContext = new WrapsDriver() {
        
        @Override
        public WebDriver getWrappedDriver() {
            return webDriver.get();
        }
        
    };

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        webDriver.set(driver);
    }
    
    public static WrapsDriver getDriverContext() {
        return driverContext;
    }

    private WebDriverManager() {

    }

}
