package pages;

import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.objects.Account;

@Getter
public class MyAccountPage extends AbstractPage {
    @FindBy(className = "logou")
    private WebElement signOutBtn;

    @FindBy(className = "account")
    private WebElement account;

    public MyAccountPage() {
        super();
    }


}
