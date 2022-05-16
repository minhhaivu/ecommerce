package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MyAccountPage extends AbstractPage {
    @FindBy(className = "logout")
    private WebElement signOutBtn;

    @FindBy(className = "account")
    private WebElement account;

    public MyAccountPage() {
        super();
    }


}
