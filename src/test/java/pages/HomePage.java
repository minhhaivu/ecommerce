package pages;

import driver.DriverGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {
    @FindBy(className = "login")
    private WebElement signInBtn;

    private String homeUrl = "http://automationpractice.com/index.php";
    private final WebDriver pageDriver;

    public HomePage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(DriverGetter.getDriver(), this);
    }

    public HomePage open() {
        pageDriver.get(homeUrl);
        System.out.println(pageDriver.getTitle() + " page is opened.");

        return this;
    }

    public HomePage clickSignIn() {
        signInBtn.click();
        System.out.println(pageDriver.getTitle() + " page is opened.");

        return this;
    }

}
