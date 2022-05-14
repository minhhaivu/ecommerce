package validation;

import org.junit.Assert;
import pages.MyAccountPage;
import pages.objects.Account;

public class SignInValidation {
    private MyAccountPage myAccountPage = new MyAccountPage();

    public void checkSignOutButtonExist() {
        Assert.assertEquals("Sign out", myAccountPage.getSignOutBtn().getText());
    }

    public void checkMyAccountTitle() {
        Assert.assertEquals("My account - My Store", myAccountPage.getPageDriver().getTitle());
    }

    public void checkAccountName(Account myAccount) {
        Assert.assertEquals(myAccountPage.getAccount().getText(), myAccount.getFirstName() + " " + myAccount.getLastName());
    }
    public void checkSignInSuccess(Account myAccount) {
        checkMyAccountTitle();
        checkSignOutButtonExist();
        checkAccountName(myAccount);
    }
}
