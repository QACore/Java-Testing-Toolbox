package com.github.qacore.testingtoolbox.selenium.elements;

import static com.github.qacore.testingtoolbox.selenium.elements.ButtonType.BUTTON;
import static com.github.qacore.testingtoolbox.selenium.elements.ButtonType.RESET;
import static com.github.qacore.testingtoolbox.selenium.elements.ButtonType.SUBMIT;
import static com.github.qacore.testingtoolbox.selenium.elements.FormEncType.APPLICATION_X_WWW_FORM_ENCODED;
import static com.github.qacore.testingtoolbox.selenium.elements.FormEncType.MULTIPART_FORM_DATA;
import static com.github.qacore.testingtoolbox.selenium.elements.FormEncType.TEXT_PLAIN;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

/**
 * Represents an HTML button.
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
public class Button extends BasicElement {

    public Button(WrapsDriver driverContext, By locator) {
        super(driverContext, locator);
    }

    public Button(WebDriver webDriver, By locator) {
        super(webDriver, locator);
    }

    public Button(By locator) {
        super(locator);
    }

    public Button(WebElement wrappedElement) {
        super(wrappedElement);
    }

    protected Button() {
        super();
    }

    /**
     * Retrieves that a button should automatically get focus when the page loads.
     * 
     * @return True if autofocus is present. Otherwise, false.
     */
    public boolean isAutoFocus() {
        return "true".equals(this.getAttribute("autofocus"));
    }

    /**
     * Retrieves the form attribute.
     * 
     * @return The form attribute.
     */
    public String getForm() {
        return this.getAttribute("form");
    }

    /**
     * Retrieves the formaction attribute.
     * 
     * @return The formaction attribute.
     */
    public URL getFormAction() {
        String formAction = this.getAttribute("formaction");

        if (formAction == null) {
            return null;
        }

        try {
            return new URL(formAction);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the formenctype attribute.
     * 
     * @return The formenctype attribute.
     */
    public FormEncType getFormEncType() {
        String formEncType = this.getAttribute("formenctype");

        if (formEncType == null) {
            return null;
        }

        switch (formEncType) {
            case "application/x-www-form-urlencoded":
                return APPLICATION_X_WWW_FORM_ENCODED;

            case "multipart/form-data":
                return MULTIPART_FORM_DATA;

            case "text/plain":
                return TEXT_PLAIN;

            default:
                throw new IllegalArgumentException(formEncType);
        }
    }

    /**
     * Retrieves the formmethod attribute.
     * 
     * @return The formmethod attribute.
     */
    public String getFormMethod() {
        return this.getAttribute("formmethod");
    }

    /**
     * Retrieves if the form-data should not be validated on submission. Only for type="submit".
     * 
     * @return True if formnovalidate is present. Otherwise, false.
     */
    public boolean isFormNoValidate() {
        return "true".equals(this.getAttribute("formnovalidate"));
    }

    /**
     * Retrieves the formtarget attribute.
     * 
     * @return The formtarget attribute.
     */
    public String getFormTarget() {
        return this.getAttribute("formtarget");
    }

    /**
     * Retrieves the type attribute.
     * 
     * @return The type attribute.
     */
    public ButtonType getType() {
        String type = this.getAttribute("type");

        if (type == null) {
            return null;
        }

        switch (type) {
            case "button":
                return BUTTON;

            case "reset":
                return RESET;

            case "submit":
                return SUBMIT;

            default:
                throw new IllegalArgumentException(type);
        }
    }

    /**
     * Retrieves the value attribute.
     * 
     * @return The value attribute.
     */
    public String getValue() {
        return this.getAttribute("value");
    }

}
