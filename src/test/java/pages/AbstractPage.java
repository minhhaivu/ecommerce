package pages;

import driver.DriverGetter;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public abstract class AbstractPage {

    protected WebDriver pageDriver = DriverGetter.getDriver();

    protected long TIME_OUT_IN_SECOND = 10000;

    public AbstractPage() {
        PageFactory.initElements(pageDriver, this);
    }

    public void close() {
        pageDriver.quit();
        DriverGetter.resetDriver();
    }

    public void hoverMouse(WebElement element) {
        scrollInToView(element);
        Actions action = new Actions(pageDriver);
        action.moveToElement(element).perform();
        new WebDriverWait(pageDriver, TIME_OUT_IN_SECOND)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollInToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) pageDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}