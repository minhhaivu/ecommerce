package org.example;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUpTest {
    @Test
    public void testSetup()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\00. Personal\\03. Material\\Selenium\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }
}
