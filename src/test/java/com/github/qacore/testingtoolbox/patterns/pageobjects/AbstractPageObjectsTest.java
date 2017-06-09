package com.github.qacore.testingtoolbox.patterns.pageobjects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qacore.testingtoolbox.managers.WebDriverManager;

import support.Mock;

public class AbstractPageObjectsTest {

    @Test
    public void constructorTest() {
        AbstractPageObjects abstractPageObjects = new AbstractPageObjects("url");

        assertEquals("url", abstractPageObjects.getUrl());

        abstractPageObjects = new AbstractPageObjects((WebDriver) null, null);

        assertEquals(WebDriverManager.getDriverContext(), abstractPageObjects.getDriverContext());
        assertEquals(WebDriverManager.getDriverContext().getWrappedDriver(), abstractPageObjects.getDriverContext().getWrappedDriver());
        assertEquals(null, abstractPageObjects.getUrl());

        WebDriver webDriver = Mock.getWebDriver();

        abstractPageObjects = new AbstractPageObjects(webDriver, "url");

        assertEquals(webDriver, abstractPageObjects.getDriverContext().getWrappedDriver());
        assertEquals("url", abstractPageObjects.getUrl());

        WrapsDriver wrapsDriver = Mock.wrapsDriver(webDriver);

        abstractPageObjects = new AbstractPageObjects(wrapsDriver, "url");

        assertEquals(wrapsDriver, abstractPageObjects.getDriverContext());
        assertEquals(wrapsDriver.getWrappedDriver(), abstractPageObjects.getDriverContext().getWrappedDriver());
        assertEquals("url", abstractPageObjects.getUrl());
    }

    @Test
    public void UrlTest() {
        AbstractPageObjects abstractPageObjects = new AbstractPageObjects("url");

        assertEquals("url", abstractPageObjects.getUrl());

        abstractPageObjects.setUrl("setUrl");
        assertEquals("setUrl", abstractPageObjects.getUrl());
    }

    @Test
    public void wrappedDriverAndDriverContextTest() {
        AbstractPageObjects abstractPageObjects = new AbstractPageObjects(null);

        assertEquals(WebDriverManager.getDriverContext(), abstractPageObjects.getDriverContext());
        assertEquals(WebDriverManager.getDriverContext().getWrappedDriver(), abstractPageObjects.getWrappedDriver());

        WebDriver webDriver = Mock.getWebDriver();
        WrapsDriver wrapsDriver = Mock.wrapsDriver(webDriver);

        abstractPageObjects.setDriverContext(wrapsDriver);

        assertEquals(wrapsDriver, abstractPageObjects.getDriverContext());
        assertEquals(webDriver, abstractPageObjects.getWrappedDriver());
    }

    @Test
    public void toStringTest() {
        assertEquals("Page(test)", new AbstractPageObjects("test").toString());
        assertEquals("Page(test)", new AbstractPageObjects((WebDriver) null, "test").toString());
        assertEquals("Page(test)", new AbstractPageObjects((WrapsDriver) null, "test").toString());
    }

}
