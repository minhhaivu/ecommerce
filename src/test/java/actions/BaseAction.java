package actions;

import driver.DriverGetter;
import org.openqa.selenium.support.PageFactory;
import pages.AbstractPage;

public abstract class BaseAction {
    protected <T extends AbstractPage> T getPageInstance(Class<T> clazz) {
        return PageFactory.initElements(DriverGetter.getDriver(), clazz);
    }

    public abstract void close();
}
