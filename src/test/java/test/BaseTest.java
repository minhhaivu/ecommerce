package test;

import org.junit.AfterClass;
import pages.BasePage;

public class BaseTest {
    @AfterClass
    public void closePage() {
        BasePage basePage = new BasePage();
        basePage.close();
    }
}
