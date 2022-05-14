package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {
    @FindBy(id = "email")
    private WebElement emailTxt;

    @FindBy(id = "passwd")
    private WebElement passwordTxt;

    @FindBy(id = "SubmitLogin")
    private WebElement getSignInBtn;

    public SignInPage() {
        super();
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
