package com.github.qacore.testingtoolbox.selenium.support.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.security.UserAndPassword;

/**
 * This interface indicates that the classes executes the basic actions of the <b>Login Page Object</b> pattern.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *         
 * @see PageObjects
 * @see WrapsDriver
 * 
 * @since 1.0.0
 * 
 */
public interface LoginPageObjects extends PageObjects {

    /**
     * Performs an authentication on the page.
     * 
     * @param userAndPassword
     *            The authentication credentials for a user with username and password.
     */
    public void loginAs(UserAndPassword userAndPassword);

    /**
     * Performs a logout on the page.
     */
    public void logout();

    /**
     * Indicates if you are logged in.
     * 
     * @param userAndPassword
     *            The authentication credentials for a user with username and password.
     * 
     * @return {@code true} if you are logged in. Otherwise, {@code false}.
     */
    public boolean isLogged(UserAndPassword userAndPassword);

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUrl();

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getWrappedDriver();

}
