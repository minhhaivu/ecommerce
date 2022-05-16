package test;

import org.junit.Test;
import pages.HomePage;
import pages.SignInPage;
import pages.objects.Account;
import validation.SignInValidation;

public class ValidSignInTest {

    @Test
    public void validSignIn() {
        String email = "minhhai.vu83@gmail.com";
        String password = "7B$viSRK$U!qqcj";
        String firstName = "Melody";
        String lastName = "Melody";

        Account myAccount = Account.builder().email(email).password(password)
                .firstName(firstName).lastName(lastName).build();

        HomePage homePage = new HomePage();
        homePage.open().clickSignIn();

        SignInPage signInPage = new SignInPage();
        signInPage.enterSignInInfo(email, password).submitSignIn();

        SignInValidation signInValidation = new SignInValidation();
        signInValidation.checkSignInSuccess(myAccount);

        signInPage.close();

    }
}
