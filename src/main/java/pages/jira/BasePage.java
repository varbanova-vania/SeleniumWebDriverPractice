package pages.jira;

import com.telerikacademy.testframework.UserActions;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final UserActions userActions;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        userActions = new UserActions();
    }

    protected abstract void waitForPageToLoad();
}
