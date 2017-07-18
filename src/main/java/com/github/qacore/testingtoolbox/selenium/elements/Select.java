package com.github.qacore.testingtoolbox.selenium.elements;

import static lombok.AccessLevel.PROTECTED;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.ISelect;

import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Delegate;

/**
 * Represents an HTML select.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 * @see BasicElement
 * @see ISelect
 * 
 * @since 1.5.0
 *
 */
@ToString(callSuper = true, doNotUseGetters = true)
public class Select extends BasicElement implements ISelect {

    @Setter(PROTECTED)
    private ISelect wrappedSelect;

    public Select(WrapsDriver driverContext, By locator) {
        super(driverContext, locator);
    }

    public Select(WebDriver webDriver, By locator) {
        super(webDriver, locator);
    }

    public Select(By locator) {
        super(locator);
    }

    public Select(WebElement wrappedElement) {
        super(wrappedElement);

        this.wrappedSelect = new org.openqa.selenium.support.ui.Select(wrappedElement);
    }

    protected Select() {
        super();
    }

    @Delegate
    public ISelect getWrappedSelect() {
        if (this.wrappedSelect == null) {
            return new org.openqa.selenium.support.ui.Select(this);
        }

        return wrappedSelect;
    }

}
