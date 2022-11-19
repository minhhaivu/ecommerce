package driver;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

@Getter
public class DriverGetter {
    private static WebDriver driver;
    private static ThreadLocal<RemoteWebDriver> remoteDriver=new ThreadLocal<>();
    private static String executionType = "remote";


    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initDriver();
        }
        return driver;
    }

    public static void resetDriver() {
        driver = null;
    }

    public static ThreadLocal<RemoteWebDriver> getRemoteDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.whitelistedIps", "");

            RemoteWebDriver remote = new RemoteWebDriver(new URL("http://localhost:4445/"), options);
            remoteDriver.set(remote);
        } catch (Exception e) {
            System.out.println(e);
        }
        return remoteDriver;
    }

    private static WebDriver initDriver() {
        switch (executionType) {
            case "local":
                driver = new ChromeDriver(initChromeOptions());
            case "remote":
                driver = getRemoteDriver().get();
        }
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
        System.setProperty("webdriver.chrome.whitelistedIps", "");

        return options;
    }
}
