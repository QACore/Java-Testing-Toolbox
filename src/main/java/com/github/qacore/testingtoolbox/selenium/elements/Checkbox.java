package com.github.qacore.testingtoolbox.selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

/**
 * Represents an HTML checkbox.
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
public class Checkbox extends BasicElement {

    public Checkbox(WrapsDriver driverContext, By locator) {
        super(driverContext, locator);
    }

    public Checkbox(WebDriver webDriver, By locator) {
        super(webDriver, locator);
    }

    public Checkbox(By locator) {
        super(locator);
    }

    public Checkbox(WebElement wrappedElement) {
        super(wrappedElement);
    }

    protected Checkbox() {
        super();
    }

    /**
     * Checks this checkbox if not checked already.
     */
    public void check() {
        if (!this.isChecked()) {
            if (this.isClicable()) {
                this.click();
            } else {
                throw new ElementNotInteractableException("Element is not clicable");
            }
        }
    }

    /**
     * Unchecks this checkbox if not unchecked already.
     */
    public void uncheck() {
        if (this.isChecked()) {
            if (this.isClicable()) {
                this.click();
            } else {
                throw new ElementNotInteractableException("Element is not clicable");
            }
        }
    }

    /**
     * Indeterminates this checkbox if not indeterminated already.
     */
    public void indeterminate() {
        if (!this.isIndeterminate()) {
            if (this.isClicable()) {
                ((JavascriptExecutor) this.getWrappedDriver()).executeScript("arguments[0].indeterminate = true", this);
            } else {
                throw new ElementNotInteractableException("Element is not clicable");
            }
        }
    }

    /**
     * Returns if this checkbox is checked or not.
     * 
     * @return True if is checked. Otherwise false.
     */
    public boolean isChecked() {
        return "true".equals(this.getAttribute("checked"));
    }

    /**
     * Returns if this checkbox is indeterminate or not.
     * 
     * @return True if is indeterminated. Otherwise false.
     */
    public boolean isIndeterminate() {
        return "true".equals(this.getAttribute("indeterminate"));
    }

    /**
     * Returns whether this checkbox is checked when the page loads.
     * 
     * @return True if this checkbox is checked when the page loads. Otherwise false.
     */
    public boolean isDefaultChecked() {
        return "true".equals(this.getAttribute("defaultChecked"));
    }

    /**
     * Retrieves this checkbox value.
     * 
     * @return The checkbox value.
     */
    public String getValue() {
        return this.getAttribute("value");
    }

    /**
     * Retrieves this checkbox default value.
     * 
     * @return The checkbox default value.
     */
    public String getDefaultValue() {
        return this.getAttribute("defaultValue");
    }

    /**
     * Retrieves that a checkbox should automatically get focus when the page loads.
     * 
     * @return True if autofocus is present. Otherwise, false.
     */
    public boolean isAutoFocus() {
        return "true".equals(this.getAttribute("autofocus"));
    }

}
