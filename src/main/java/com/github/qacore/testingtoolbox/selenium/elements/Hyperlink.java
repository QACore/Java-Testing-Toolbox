package com.github.qacore.testingtoolbox.selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

/**
 * Represents an HTML hyperlink.
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
public class Hyperlink extends BasicElement {

    public Hyperlink(WrapsDriver driverContext, By locator) {
        super(driverContext, locator);
    }

    public Hyperlink(WebDriver webDriver, By locator) {
        super(webDriver, locator);
    }

    public Hyperlink(By locator) {
        super(locator);
    }

    public Hyperlink(WebElement wrappedElement) {
        super(wrappedElement);
    }

    protected Hyperlink() {
        super();
    }

    /**
     * Retrieves the specified URL of the page the link goes to.
     * 
     * @return The href of this link.
     * 
     * @since 1.5.0
     */
    public String getHref() {
        return this.getAttribute("href");
    }

    /**
     * Retrieves the specification of where to open the linked document.
     * 
     * @return The target of this link.
     * 
     * @since 1.5.0
     */
    public String getTarget() {
        return this.getAttribute("target");
    }

}
