package com.github.qacore.testingtoolbox.patterns.pageobjects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.github.qacore.testingtoolbox.managers.WebDriverManager;

import support.Mock;

public class PageObjectsTest {

    @Test
    public void wrappedDriverTest() {
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
