package com.github.qacore.testingtoolbox.selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

/**
 * Represents an HTML label.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 * @see BasicElement
 * 
 * @since 1.5.0
 *
 */
public class Label extends BasicElement {

    public Label(WrapsDriver driverContext, By locator) {
        super(driverContext, locator);
    }

    public Label(WebDriver webDriver, By locator) {
        super(webDriver, locator);
    }

    public Label(By locator) {
        super(locator);
    }

    public Label(WebElement wrappedElement) {
        super(wrappedElement);
    }

    protected Label() {
        super();
    }

    /**
     * Retrieves the form element id this label is bound to.
     * 
     * @return The for attribute of this label.
     */
    public String getFor() {
        return this.getAttribute("for");
    }

}
