package com.github.qacore.testingtoolbox.patterns.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qacore.testingtoolbox.managers.WebDriverManager;

/**
 * Managed page objects. It supports parallel browsers.
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
 * @since 1.0.0
 * 
 */
public class AbstractPageObjects implements PageObjects {

    private WrapsDriver driverContext;
    private String      url;

    public AbstractPageObjects(WrapsDriver driverContext, String url) {
        if (driverContext == null) {
            this.driverContext = WebDriverManager.getDriverContext();
        } else {
            this.driverContext = driverContext;
        }

        this.url = url;
    }

    public AbstractPageObjects(WebDriver webDriver, String url) {
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

        this.url = url;
    }

    public AbstractPageObjects(String url) {
        this.driverContext = WebDriverManager.getDriverContext();
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }

    protected void setUrl(String url) {
        this.url = url;
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
        return "Page(" + this.getUrl() + ")";
    }

}
