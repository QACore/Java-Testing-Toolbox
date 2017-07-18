package com.github.qacore.testingtoolbox.selenium.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;

/**
 * Represents an HTML element.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @see Element
 * 
 * @since 1.5.0
 *
 */
public interface Element extends WebElement, Locatable {

    /**
     * Retrieves the id of this element.
     * 
     * @return The id of this element.
     * 
     * @since 1.5.0
     */
    public String getId();

    /**
     * Retrieves the name of this element.
     * 
     * @return The name of this element.
     * 
     * @since 1.5.0
     */
    public String getName();

    /**
     * Retrieves the style class of this element.
     * 
     * @return The style class of this element.
     * 
     * @since 1.5.0
     */
    public List<String> getStyleClass();

    /**
     * Retrieves the title of this element.
     * 
     * @return The title of this element.
     * 
     * @since 1.5.0
     */
    public String getTitle();

    /**
     * Retrieves the locator of this element.
     * 
     * @return The locator of this element.
     * 
     * @since 1.5.0
     */
    public By getLocator();

}
