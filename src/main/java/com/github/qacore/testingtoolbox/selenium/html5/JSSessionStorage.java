package com.github.qacore.testingtoolbox.selenium.html5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qacore.testingtoolbox.selenium.parallel.ManagedWebDriverContext;

/**
 * Represents the session storage in the browser for the site currently opened in the browser. The session storage areas is specific to the current top level browsing context. Each context has a unique set of session storage, one for each origin. Sites can add data to the session storage and it will be accessible to any page from the same site opened in that window.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @see SessionStorage
 * @see ManagedWebDriverContext
 *
 * @since 1.2.0
 * 
 */
public class JSSessionStorage extends ManagedWebDriverContext implements SessionStorage {

    public JSSessionStorage(WrapsDriver driverContext) {
        super(driverContext);
    }

    public JSSessionStorage(WebDriver webDriver) {
        super(webDriver);
    }

    public JSSessionStorage() {
        super();
    }

    @Override
    public String getItem(String key) {
        return (String) ((JavascriptExecutor) this.getWrappedDriver()).executeScript("return sessionStorage.getItem('" + key.replace("'", "\\'") + "')");
    }

    @Override
    public Set<String> keySet() {
        @SuppressWarnings("unchecked")
        List<String> keySet = (ArrayList<String>) ((JavascriptExecutor) this.getWrappedDriver()).executeScript("return Object.keys(sessionStorage)");

        return new HashSet<>(keySet);
    }

    @Override
    public void setItem(String key, String value) {
        ((JavascriptExecutor) this.getWrappedDriver()).executeScript("sessionStorage.setItem('" + key.replace("'", "\\'") + "','" + value.replace("'", "\\'") + "');");
    }

    @Override
    public String removeItem(String key) {
        String item = this.getItem(key);

        ((JavascriptExecutor) this.getWrappedDriver()).executeScript("sessionStorage.removeItem('" + key.replace("'", "\\'") + "')");

        return item;
    }

    @Override
    public void clear() {
        ((JavascriptExecutor) this.getWrappedDriver()).executeScript("sessionStorage.clear()");
    }

    @Override
    public int size() {
        return (int) (long) ((JavascriptExecutor) this.getWrappedDriver()).executeScript("return sessionStorage.length");
    }

}
