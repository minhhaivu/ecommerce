package test;

import org.testng.Reporter;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SignInPage;
import pages.objects.Account;
import validation.SignInValidation;

@Listeners({listeners.CustomizedEmailableReporter.class,listeners.CustomizedMethodInterceptor.class})
public class ValidSignInTest {

    @Test(description = "Sign in with a valid account",attributes = {
            @CustomAttribute(name="ID",values = {"211183"}),
            @CustomAttribute(name="businessValue",values = {"5"})
    })
    public void verifySignIn() {
        String email = "minhhai.vu83@gmail.com";
        String password = "7B$viSRK$U!qqcj";
        String firstName = "Melody";
        String lastName = "Melody";

        Account myAccount = Account.builder().email(email).password(password)
                .firstName(firstName).lastName(lastName).build();

        Reporter.log("Step 1: Open Home page.");
        BasePage basePage = new BasePage();
        basePage.open().clickSignIn();

        SignInPage signInPage = new SignInPage();
        Reporter.log("Step 2: Click SignIn button.");
        Reporter.log("Step 3: Enter a valid username & password.");
        signInPage.enterSignInInfo(email, password).submitSignIn();

        SignInValidation signInValidation = new SignInValidation();
        signInValidation.checkSignInSuccess(myAccount);
        Reporter.log("Verify that user can sign in successfully.");

        basePage.close();
    }
}
