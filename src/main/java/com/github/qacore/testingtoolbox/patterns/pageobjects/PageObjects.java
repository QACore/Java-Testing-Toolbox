package com.github.qacore.testingtoolbox.patterns.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

/**
 * This interface indicates that the classes executes the basic actions of the <b>Page Object</b> pattern.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/LeoCarmona">https://github.com/LeoCarmona</a></li>
 *         </ul>
 * 
 * @see LoginPageObjects
 * @see WrapsDriver
 * 
 */
public interface PageObjects extends WrapsDriver {

    /**
     * Load the page in the current browser window.
     */
    public default void open() {
        this.getWrappedDriver().get(this.getUrl());
    }

    /**
     * The URL to load. It is best to use a fully qualified URL.
     * 
     * @return The URL to load.
     */
    public String getUrl();

    /**
     * The driver used on the page.
     * 
     * @return the {@link WebDriver} used on the page.
     */
    @Override
    public WebDriver getWrappedDriver();

}
