package com.github.qacore.testingtoolbox.selenium.support.pageobjects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qacore.testingtoolbox.junit.runners.parallel.Parallel;
import com.github.qacore.testingtoolbox.selenium.support.pageobjects.AbstractPageObjects;

@RunWith(Parallel.class)
public class AbstractPageObjectsTest {

    @Test
    public void constructor_WrapsDriver_String_Test() {
        AbstractPageObjects abstractPageObjects = new AbstractPageObjects((WrapsDriver) null, null);
        assertEquals(null, abstractPageObjects.getUrl());

        abstractPageObjects = new AbstractPageObjects((WrapsDriver) null, "test");
        assertEquals("test", abstractPageObjects.getUrl());
    }

    @Test
    public void constructor_WebDriver_String_Test() {
        AbstractPageObjects abstractPageObjects = new AbstractPageObjects((WebDriver) null, null);
        assertEquals(null, abstractPageObjects.getUrl());

        abstractPageObjects = new AbstractPageObjects((WebDriver) null, "test");
        assertEquals("test", abstractPageObjects.getUrl());
    }

    @Test
    public void constructor_String_Test() {
        AbstractPageObjects abstractPageObjects = new AbstractPageObjects(null);
        assertEquals(null, abstractPageObjects.getUrl());

        abstractPageObjects = new AbstractPageObjects("url");
        assertEquals("url", abstractPageObjects.getUrl());
    }
    
    @Test
    public void setUrl_Test() {
        AbstractPageObjects abstractPageObjects = new AbstractPageObjects(null);

        abstractPageObjects.setUrl(null);
        assertEquals(null, abstractPageObjects.getUrl());
        
        abstractPageObjects.setUrl("url");
        assertEquals("url", abstractPageObjects.getUrl());
    }

    @Test
    public void toStringTest() {
        assertEquals("Page(test)", new AbstractPageObjects("test").toString());
        assertEquals("Page(test)", new AbstractPageObjects((WebDriver) null, "test").toString());
        assertEquals("Page(test)", new AbstractPageObjects((WrapsDriver) null, "test").toString());
    }

}
