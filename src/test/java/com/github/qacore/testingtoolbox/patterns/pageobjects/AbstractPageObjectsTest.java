package com.github.qacore.testingtoolbox.patterns.pageobjects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

public class AbstractPageObjectsTest {

    @Test
    public void toStringTest() {
        assertEquals("Page(test)", new AbstractPageObjects("test").toString());
        assertEquals("Page(test)", new AbstractPageObjects((WebDriver) null, "test").toString());
        assertEquals("Page(test)", new AbstractPageObjects((WrapsDriver) null, "test").toString());
    }

}
