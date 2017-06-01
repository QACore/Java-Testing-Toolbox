package com.github.qacore.testingtoolbox.patterns.pageobjects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.security.UserAndPassword;

public class AbstractLoginPageObjectsTest {

    @Test
    public void toStringTest() {
        assertEquals("LoginPage(test)", new AbstractLoginPageObjects("test") {

            @Override
            public void logout() {

            }

            @Override
            public void loginAs(UserAndPassword userAndPassword) {

            }

            @Override
            public boolean isLogged(UserAndPassword userAndPassword) {
                return false;
            }

        }.toString());

        assertEquals("LoginPage(test)", new AbstractLoginPageObjects((WebDriver) null, "test") {

            @Override
            public void logout() {

            }

            @Override
            public void loginAs(UserAndPassword userAndPassword) {

            }

            @Override
            public boolean isLogged(UserAndPassword userAndPassword) {
                return false;
            }

        }.toString());

        assertEquals("LoginPage(test)", new AbstractLoginPageObjects((WrapsDriver) null, "test") {

            @Override
            public void logout() {

            }

            @Override
            public void loginAs(UserAndPassword userAndPassword) {

            }

            @Override
            public boolean isLogged(UserAndPassword userAndPassword) {
                return false;
            }

        }.toString());
    }

}
