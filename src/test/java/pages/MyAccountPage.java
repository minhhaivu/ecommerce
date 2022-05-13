package pages;

import driver.DriverGetter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Account;

public class MyAccountPage {
    @FindBy(className = "logout")
    private WebElement signOutBtn;

    @FindBy(className = "account")
    private WebElement account;

    private final WebDriver pageDriver;

    public MyAccountPage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(DriverGetter.getDriver(), this);
    }

    public void checkSignInSuccess(Account myAccount) {
        Assert.assertEquals("My account - My Store", pageDriver.getTitle());
        Assert.assertEquals("Sign out", signOutBtn.getText());
        Assert.assertEquals(account.getText(), myAccount.getFirstName() + " " + myAccount.getLastName());

    }

}
