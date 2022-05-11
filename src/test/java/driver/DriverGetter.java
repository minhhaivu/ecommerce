package driver;

import lombok.Getter;;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

@Getter
@NoArgsConstructor
public class DriverGetter {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            driver = initDriver();
        }

        return driver;
    }

    private static WebDriver initDriver() {
        WebDriver driver = null;
        driver = new ChromeDriver(initChromeOptions());
        driver.get("http://automationpractice.com/index.php");
        return driver;
    }

    private static ChromeOptions initChromeOptions() {
        String chromeHome = System.getenv("CHROME_HOME");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setBinary(chromeHome + "\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", chromeHome + "\\chromedriver.exe");

        return options;
    }
}
