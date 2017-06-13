package com.github.qacore.testingtoolbox.selenium.support.pageobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.qacore.testingtoolbox.selenium.parallel.WebDriverManager;

import support.Mock;

public class PageObjectsTest {

    private ThreadLocal<String> externalUrl = new ThreadLocal<>();

    @Before
    public void setup() {
        externalUrl.set(null);
    }

    @Test
    public void openTest() {
        WebDriver webDriver = new WebDriver() {

            @Override
            public TargetLocator switchTo() {
                return null;
            }

            @Override
            public void quit() {

            }

            @Override
            public Navigation navigate() {
                return null;
            }

            @Override
            public Options manage() {
                return null;
            }

            @Override
            public Set<String> getWindowHandles() {
                return null;
            }

            @Override
            public String getWindowHandle() {
                return null;
            }

            @Override
            public String getTitle() {
                return null;
            }

            @Override
            public String getPageSource() {
                return null;
            }

            @Override
            public String getCurrentUrl() {
                return null;
            }

            @Override
            public void get(String url) {
                externalUrl.set(url);
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
            }

            @Override
            public void close() {

            }

        };

        assertNull(externalUrl.get());

        PageObjects pageObjects = new PageObjects() {

            @Override
            public String getUrl() {
                return "url";
            }

            @Override
            public WebDriver getWrappedDriver() {
                return webDriver;
            }

        };

        assertNull(externalUrl.get());

        pageObjects.open();

        assertEquals("url", externalUrl.get());
    }

    @Test
    public void isLoadedTest() {
        WebDriver webDriver = new WebDriver() {

            @Override
            public TargetLocator switchTo() {
                return null;
            }

            @Override
            public void quit() {

            }

            @Override
            public Navigation navigate() {
                return null;
            }

            @Override
            public Options manage() {
                return null;
            }

            @Override
            public Set<String> getWindowHandles() {
                return null;
            }

            @Override
            public String getWindowHandle() {
                return null;
            }

            @Override
            public String getTitle() {
                return null;
            }

            @Override
            public String getPageSource() {
                return null;
            }

            @Override
            public String getCurrentUrl() {
                return "url";
            }

            @Override
            public void get(String url) {

            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
            }

            @Override
            public void close() {

            }

        };

        PageObjects pageObjects = new PageObjects() {

            @Override
            public String getUrl() {
                return "url";
            }

            @Override
            public WebDriver getWrappedDriver() {
                return webDriver;
            }

        };

        assertTrue(pageObjects.isLoaded());

        pageObjects = new PageObjects() {

            @Override
            public String getUrl() {
                return "wrongUrl";
            }

            @Override
            public WebDriver getWrappedDriver() {
                return webDriver;
            }

        };

        assertFalse(pageObjects.isLoaded());
    }

    @Test
    public void getWrappedDriverTest() {
        PageObjects pageObjects = new PageObjects() {

            @Override
            public String getUrl() {
                return null;
            }

        };

        assertEquals(WebDriverManager.getDriver(), pageObjects.getWrappedDriver());
        assertEquals(WebDriverManager.getDriverContext().getWrappedDriver(), pageObjects.getWrappedDriver());

        WebDriver webDriver = Mock.getWebDriver();
        WebDriverManager.setDriver(webDriver);

        assertEquals(webDriver, pageObjects.getWrappedDriver());
    }

}
