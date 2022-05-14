package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(className = "login")
    private WebElement signInBtn;

    private final String HOME_URL = "http://automationpractice.com/index.php";

    public HomePage() {
        super();
    }

    public HomePage open() {

        pageDriver.get(HOME_URL);
        System.out.println(pageDriver.getTitle() + " page is opened.");

        return this;
    }

    public HomePage clickSignIn() {
        signInBtn.click();
        System.out.println(pageDriver.getTitle() + " page is opened.");

        return this;
    }

}
