package com.github.qacore.testingtoolbox.selenium.parallel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.github.qacore.testingtoolbox.junit.runners.Parallel;

import support.Mock;

@RunWith(Parallel.class)
public class WebDriverManagerTest {

    @Before
    public void setup() {
        WebDriverManager.setDriver(null);
    }

    @Test
    public void privateConstructorTest() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?> emptyPrivateConstructor = WebDriverManager.class.getDeclaredConstructor();

        assertEquals(1, WebDriverManager.class.getDeclaredConstructors().length);
        assertTrue(Modifier.isPrivate(emptyPrivateConstructor.getModifiers()));

        emptyPrivateConstructor.setAccessible(true);
        emptyPrivateConstructor.newInstance();
    }

    @Test
    public void getDriverContext() {
        WebDriver webDriver = Mock.getWebDriver();

        WebDriverManager.setDriver(webDriver);
        assertEquals(webDriver, WebDriverManager.getDriver());
        assertEquals(webDriver, WebDriverManager.getDriverContext().getWrappedDriver());
    }

    @Test
    public void toStringTest() {
        WebDriver webDriver = Mock.getWebDriver();

        WebDriverManager.setDriver(webDriver);
        assertEquals("WebDriverManager(thread=" + Thread.currentThread().getName() + ", driver=" + webDriver + ")", WebDriverManager.getDriverContext().toString());
    }

}
