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
        String chromeHome = System.getenv("CHROME_HOME");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(chromeHome + "\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", chromeHome + "\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.google.com");
        assertEquals("Google", driver.getTitle());
        driver.close();
    }
}
