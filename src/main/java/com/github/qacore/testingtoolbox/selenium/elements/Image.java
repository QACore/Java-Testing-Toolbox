package com.github.qacore.testingtoolbox.selenium.elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

/**
 * Represents an HTML image.
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
public class Image extends BasicElement {

    public Image(WrapsDriver driverContext, By locator) {
        super(driverContext, locator);
    }

    public Image(WebDriver webDriver, By locator) {
        super(webDriver, locator);
    }

    public Image(By locator) {
        super(locator);
    }

    public Image(WebElement wrappedElement) {
        super(wrappedElement);
    }

    protected Image() {
        super();
    }

    /**
     * Retrieves the alt of this image.
     * 
     * @return The alt of this image.
     */
    public String getAlt() {
        return this.getAttribute("alt");
    }

    /**
     * Retrieves the src of this image.
     * 
     * @return The src of this image.
     */
    public String getSrc() {
        return this.getAttribute("src");
    }

    /**
     * Download the image to specified path.
     * 
     * @param pathname
     *            A pathname string.
     * 
     * @param connectionTimeout
     *            The number of milliseconds until this method will timeout if no connection could be established to the <code>source</code>.
     * 
     * @param readTimeout
     *            The number of milliseconds until this method will timeout if no data could be read from the <code>source</code>.
     * 
     * @return The file.
     */
    public File downloadImage(String pathname, int connectionTimeout, int readTimeout) {
        File file = new File(pathname);

        try {
            FileUtils.copyURLToFile(new URL(this.getSrc()), file, connectionTimeout, readTimeout);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return file;
    }

    /**
     * Download the image to specified path.
     * 
     * @param pathname
     *            A pathname string.
     * 
     * @return The file.
     */
    public File downloadImage(String pathname) {
        File file = new File(pathname);

        try {
            FileUtils.copyURLToFile(new URL(this.getSrc()), file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return file;
    }

}
