package test;

import org.junit.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;
import pages.objects.Account;
import validation.SignInValidation;

public class ValidSignInTest {

    @Test
    public void ValidSignInTest() {
        String email = "minhhai.vu83@gmail.com";
        String password = "7B$viSRK$U!qqcj";
        String firstName = "Melody";
        String lastName = "Melody";

        Account myAccount = new Account(email, password, firstName, lastName);
        Account.builder().email(email).password(password)
                .firstName(firstName).lastName(lastName).build();

        HomePage homePage = new HomePage();
        homePage.open().clickSignIn();

        SignInPage signInPage = new SignInPage();
        signInPage.enterSignInInfo(email, password).submitSignIn();

        SignInValidation signInValidation = new SignInValidation();
        signInValidation.checkSignInSuccess(myAccount);

    }
}
