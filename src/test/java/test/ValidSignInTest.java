package test;

import driver.DriverGetter;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;
import pages.objects.Account;

public class ValidSignInTest {

    @Test
    public void testSetup() {
        String email = "minhhai.vu83@gmail.com";
        String password = "7B$viSRK$U!qqcj";
        String firstName = "Melody";
        String lastName = "Melody";

        Account myAccount = new Account(email, password, firstName, lastName);

        WebDriver pageDriver = DriverGetter.getDriver();

        HomePage homePage = new HomePage(pageDriver);
        homePage.open().clickSignIn();

        SignInPage signInPage = new SignInPage(pageDriver);
        signInPage.enterSignInInfo(email, password).submitSignIn();

        MyAccountPage myAccountPage = new MyAccountPage(pageDriver);
        myAccountPage.checkSignInSuccess(myAccount);

    }
}
