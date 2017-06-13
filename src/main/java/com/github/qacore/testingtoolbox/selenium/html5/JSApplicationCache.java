package com.github.qacore.testingtoolbox.selenium.html5;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.AppCacheStatus;
import org.openqa.selenium.html5.ApplicationCache;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qacore.testingtoolbox.selenium.parallel.ManagedWebDriverContext;

/**
 * Represents the application cache status.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 * @see ApplicationCache
 * @see ManagedWebDriverContext
 *
 * @since 1.2.0
 * 
 */
public class JSApplicationCache extends ManagedWebDriverContext implements ApplicationCache {

    public JSApplicationCache(WrapsDriver driverContext) {
        super(driverContext);
    }

    public JSApplicationCache(WebDriver webDriver) {
        super(webDriver);
    }

    public JSApplicationCache() {
        super();
    }

    @Override
    public AppCacheStatus getStatus() {
        return AppCacheStatus.getEnum((int) (long) ((JavascriptExecutor) this.getWrappedDriver()).executeScript("return applicationCache.status"));
    }

}
