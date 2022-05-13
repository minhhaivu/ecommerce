package pages;

import driver.DriverGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {
    @FindBy(id = "email")
    private WebElement emailTxt;

    @FindBy(id = "passwd")
    private WebElement passwordTxt;

    @FindBy(id = "SubmitLogin")
    private WebElement getSignInBtn;

    private final WebDriver pageDriver;

    public SignInPage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(DriverGetter.getDriver(), this);
    }

    public SignInPage enterSignInInfo(String userEmail, String password) {
        emailTxt.sendKeys(userEmail);
        passwordTxt.sendKeys(password);

        return this;
    }

    public void submitSignIn() {
        getSignInBtn.click();
    }

}
