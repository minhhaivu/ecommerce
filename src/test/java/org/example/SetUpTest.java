package org.example;

import driver.DriverGetter;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.testng.AssertJUnit.assertEquals;

public class SetUpTest {
    @Test
    public void testSetup() {
        String url = "http://www.google.com";
        String chromeBinary = System.getenv("CHROME_BINARY");
        String chromeDriver = System.getenv("CHROME_DRIVER");
        String chromeVersion = System.getenv("CHROME_VERSION");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(chromeBinary);
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        System.out.println("--------------Logging---------------");
        System.out.println("URL: " + url);
        System.out.println("Chrome version: " + chromeVersion);
        System.out.println("Chrome binary directory: " + chromeBinary);
        System.out.println("Chrome driver directory: " + chromeDriver);
        assertEquals("Google", driver.getTitle());
        driver.close();
    }
}
