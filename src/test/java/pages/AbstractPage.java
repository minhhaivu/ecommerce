package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver pageDriver;

    public void close() {
        pageDriver.quit();
    }
}