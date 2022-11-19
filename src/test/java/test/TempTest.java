package test;

import org.testng.Reporter;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({listeners.CustomizedEmailableReporter.class,listeners.CustomizedMethodInterceptor.class})
public class TempTest {

    @Test(groups = {"High"},description = "Sign in with a valid account",attributes = {
            @CustomAttribute(name="ID",values = {"211183"}),
            @CustomAttribute(name="businessValue",values = {"5"})
    })
    public void verifyJenkins() {
        Reporter.log("Step 1: Open Home page.");
        Reporter.log("Step 2: Click SignIn button.");
        Reporter.log("Step 3: Enter a valid username & password.");
        Reporter.log("Verify that user can sign in successfully.");

    }

    @Test(groups = {"Medium"},description = "Log out",attributes = {
            @CustomAttribute(name="ID",values = {"131188"}),
            @CustomAttribute(name="businessValue",values = {"4"})
    })
    public void verifyLogOut() {
        Reporter.log("Step 1: Open Home page.");
        Reporter.log("Step 2: Click SignIn button.");
        Reporter.log("Step 3: Enter a valid username & password.");
        Reporter.log("Step 4: Click SignOut button");
        Reporter.log("Verify that user sign out successfully.");

    }
}
