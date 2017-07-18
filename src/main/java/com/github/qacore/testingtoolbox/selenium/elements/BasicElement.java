package com.github.qacore.testingtoolbox.selenium.elements;

import static lombok.AccessLevel.PROTECTED;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;

import com.github.qacore.testingtoolbox.selenium.parallel.ManagedWebDriverContext;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Delegate;

/**
 * Represents a basic HTML element.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @see Element
 * @see WrapsElement
 * @see ManagedWebDriverContext
 * 
 * @since 1.5.0
 *
 */
public class BasicElement extends ManagedWebDriverContext implements Element, WrapsElement {

    @Getter
    @Setter(PROTECTED)
    private By         locator;

    @Setter(PROTECTED)
    private WebElement wrappedElement;

    public BasicElement(WrapsDriver driverContext, @NonNull By locator) {
        super(driverContext);

        this.locator = locator;
    }

    public BasicElement(WebDriver webDriver, @NonNull By locator) {
        super(webDriver);

        this.locator = locator;
    }

    public BasicElement(@NonNull By locator) {
        super();

        this.locator = locator;
    }

    public BasicElement(@NonNull WebElement wrappedElement) {
        super();

        this.wrappedElement = wrappedElement;
    }

    protected BasicElement() {
        super();
    }

    @Override
    public String getId() {
        return this.getAttribute("id");
    }

    @Override
    public String getName() {
        return this.getAttribute("name");
    }

    @Override
    public List<String> getStyleClass() {
        String styleClass = this.getAttribute("class");

        if (styleClass == null) {
            return new ArrayList<>();
        }

        List<String> styleClasses = new ArrayList<>();

        for (String s : styleClass.trim().split(" ")) {
            if (!"".equals(s)) {
                styleClasses.add(s);
            }
        }

        return styleClasses;
    }

    @Override
    public String getTitle() {
        return this.getAttribute("title");
    }

    @Delegate
    @Override
    public WebElement getWrappedElement() {
        if (wrappedElement == null) {
            return this.getWrappedDriver().findElement(this.getLocator());
        }

        return wrappedElement;
    }

    @Override
    public Coordinates getCoordinates() {
        WebElement element = this.getWrappedElement();

        if (element instanceof Coordinates) {
            return (Coordinates) element;
        }

        return null;
    }

}
