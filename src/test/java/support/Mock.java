package support;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public final class Mock {

    public static WrapsDriver wrapsDriver(WebDriver webDriver) {
        return new WrapsDriver() {

            @Override
            public WebDriver getWrappedDriver() {
                return webDriver;
            }

        };
    }

    public static WebDriver getWebDriver() {
        return new WebDriver() {

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
    }

    private Mock() {

    }

}
