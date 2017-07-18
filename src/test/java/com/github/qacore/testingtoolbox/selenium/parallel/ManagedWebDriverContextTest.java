package com.github.qacore.testingtoolbox.selenium.parallel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qacore.testingtoolbox.junit.runners.parallel.Parallel;

import support.Mock;
import support.Validations;

@RunWith(Parallel.class)
public class ManagedWebDriverContextTest {

    @Before
    public void setupDefault() {
        WebDriverManager.setDriver(null);
    }

    @Test
    public void constructor_Empty_Test() {
        ManagedWebDriverContext managedWebDriverContext = new ManagedWebDriverContext();

        assertEquals(WebDriverManager.getDriverContext(), managedWebDriverContext.getDriverContext());
        assertEquals(WebDriverManager.getDriverContext().getWrappedDriver(), managedWebDriverContext.getDriverContext().getWrappedDriver());

        WebDriver webDriver = Mock.getWebDriver();
        WebDriverManager.setDriver(webDriver);

        assertEquals(WebDriverManager.getDriverContext(), managedWebDriverContext.getDriverContext());
        assertEquals(webDriver, managedWebDriverContext.getDriverContext().getWrappedDriver());
    }

    @Test
    public void constructor_WebDriver_Test() {
        // null
        ManagedWebDriverContext managedWebDriverContext = new ManagedWebDriverContext((WebDriver) null);

        assertEquals(WebDriverManager.getDriverContext(), managedWebDriverContext.getDriverContext());
        assertEquals(WebDriverManager.getDriverContext().getWrappedDriver(), managedWebDriverContext.getDriverContext().getWrappedDriver());

        // non-null
        WebDriver webDriver = Mock.getWebDriver();
        managedWebDriverContext = new ManagedWebDriverContext(webDriver);

        assertEquals(webDriver, managedWebDriverContext.getDriverContext().getWrappedDriver());
    }

    @Test
    public void constructor_WrapsDriver_Test() {
        // null
        ManagedWebDriverContext managedWebDriverContext = new ManagedWebDriverContext((WrapsDriver) null);

        assertEquals(WebDriverManager.getDriverContext(), managedWebDriverContext.getDriverContext());
        assertEquals(WebDriverManager.getDriverContext().getWrappedDriver(), managedWebDriverContext.getDriverContext().getWrappedDriver());

        // non-null
        WebDriver webDriver = Mock.getWebDriver();
        WrapsDriver wrapsDriver = Mock.wrapsDriver(webDriver);
        managedWebDriverContext = new ManagedWebDriverContext(wrapsDriver);

        assertEquals(wrapsDriver, managedWebDriverContext.getDriverContext());
        assertEquals(webDriver, managedWebDriverContext.getDriverContext().getWrappedDriver());
    }

    @Test
    public void setAndGetDriverContextTest() {
        ManagedWebDriverContext managedWebDriverContext = new ManagedWebDriverContext();

        managedWebDriverContext.setDriverContext(null);
        assertNull(managedWebDriverContext.getDriverContext());

        WebDriver webDriver = Mock.getWebDriver();
        WrapsDriver wrapsDriver = Mock.wrapsDriver(webDriver);

        managedWebDriverContext.setDriverContext(wrapsDriver);

        assertEquals(wrapsDriver, managedWebDriverContext.getDriverContext());
        assertEquals(webDriver, managedWebDriverContext.getDriverContext().getWrappedDriver());
        assertEquals(webDriver, managedWebDriverContext.getWrappedDriver());
    }

    @Test
    public void toStringTest() {
        Validations.assertLombokToString(new ManagedWebDriverContext(Mock.wrapsDriver(Mock.getWebDriver())));
    }

}
