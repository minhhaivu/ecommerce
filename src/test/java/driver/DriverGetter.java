package driver;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

@Getter
public class DriverGetter {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            driver = initDriver();
        }
        return driver;
    }

    private static WebDriver initDriver() {
        driver = new ChromeDriver(initChromeOptions());
        return driver;
    }

    private static ChromeOptions initChromeOptions() {
        String chromeHome = System.getenv("CHROME_BINARY");
        String chromeDriver = System.getenv("CHROME_DRIVER");
        String chromeVersion = System.getenv("CHROME_VERSION");
        System.out.println("Chrome version: " + chromeVersion);
        System.out.println("Chrome binary directory: " + chromeHome);
        System.out.println("Chrome driver directory: " + chromeDriver);

        ChromeOptions options = new ChromeOptions();
        options.setBinary(chromeHome);
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", chromeDriver);

        return options;
    }
}
