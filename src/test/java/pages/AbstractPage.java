package pages;

import driver.DriverGetter;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public abstract class AbstractPage {

    protected WebDriver pageDriver = DriverGetter.getDriver();

    public AbstractPage () {
        PageFactory.initElements(pageDriver,this);
    }

    public void close() {
        pageDriver.quit();
    }
}