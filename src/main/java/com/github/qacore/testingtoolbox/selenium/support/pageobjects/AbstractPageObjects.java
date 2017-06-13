package com.github.qacore.testingtoolbox.selenium.support.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qacore.testingtoolbox.selenium.parallel.ManagedWebDriverContext;

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
 * @see ManagedWebDriverContext
 * @see PageObjects
 * 
 * @since 1.0.0
 * 
 */
public class AbstractPageObjects extends ManagedWebDriverContext implements PageObjects {

    private String url;

    public AbstractPageObjects(WrapsDriver driverContext, String url) {
        super(driverContext);

        this.url = url;
    }

    public AbstractPageObjects(WebDriver webDriver, String url) {
        super(webDriver);

        this.url = url;
    }

    public AbstractPageObjects(String url) {
        super();

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
    public String toString() {
        return "Page(" + this.getUrl() + ")";
    }

}
