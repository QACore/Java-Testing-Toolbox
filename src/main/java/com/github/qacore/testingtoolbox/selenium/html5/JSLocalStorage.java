package com.github.qacore.testingtoolbox.selenium.html5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qacore.testingtoolbox.selenium.parallel.ManagedWebDriverContext;

/**
 * Represents the local storage for the site currently opened in the browser. Each site has its own separate storage area.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @see ManagedWebDriverContext
 *
 * @since 1.2.0
 */
public class JSLocalStorage extends ManagedWebDriverContext implements LocalStorage {

    public JSLocalStorage(WrapsDriver driverContext) {
        super(driverContext);
    }

    public JSLocalStorage(WebDriver webDriver) {
        super(webDriver);
    }

    public JSLocalStorage() {
        super();
    }

    @Override
    public String getItem(String key) {
        return (String) ((JavascriptExecutor) this.getWrappedDriver()).executeScript("return localStorage.getItem('" + key.replace("'", "\\'") + "')");
    }

    @Override
    public Set<String> keySet() {
        @SuppressWarnings("unchecked")
        List<String> keySet = (ArrayList<String>) ((JavascriptExecutor) this.getWrappedDriver()).executeScript("return Object.keys(localStorage)");

        return new HashSet<>(keySet);
    }

    @Override
    public void setItem(String key, String value) {
        ((JavascriptExecutor) this.getWrappedDriver()).executeScript("localStorage.setItem('" + key.replace("'", "\\'") + "','" + value.replace("'", "\\'") + "');");
    }

    @Override
    public String removeItem(String key) {
        String item = this.getItem(key);

        ((JavascriptExecutor) this.getWrappedDriver()).executeScript("localStorage.removeItem('" + key.replace("'", "\\'") + "')");

        return item;
    }

    @Override
    public void clear() {
        ((JavascriptExecutor) this.getWrappedDriver()).executeScript("localStorage.clear()");
    }

    @Override
    public int size() {
        return Integer.parseInt(String.valueOf(((JavascriptExecutor) this.getWrappedDriver()).executeScript("return localStorage.length")));
    }

}
