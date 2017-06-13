package com.github.qacore.testingtoolbox.selenium.support.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qacore.testingtoolbox.selenium.parallel.WebDriverManager;

/**
 * Managed login page objects. It supports parallel browsers.
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
public abstract class AbstractLoginPageObjects extends AbstractPageObjects implements LoginPageObjects {

    public AbstractLoginPageObjects(WrapsDriver driverContext, String url) {
        super(driverContext, url);
    }

    public AbstractLoginPageObjects(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public AbstractLoginPageObjects(String url) {
        super(url);
    }

    @Override
    public String toString() {
        return "LoginPage(" + this.getUrl() + ")";
    }

}
