package pages.jira.login;

import com.telerikacademy.testframework.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.jira.BasePage;

import static pages.jira.enums.ConfigKeys.START_PAGE_URL;

public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void openJiraSoftware() {
        waitForPageToLoad();
        jiraSoftwareButton().click();
    }

    protected void waitForPageToLoad() {
        userActions.waitForElementVisible(Utils.getUIMappingByKey("jira.startPage.jiraSoftwareButton"));
    }

    private WebElement jiraSoftwareButton() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.startPage.jiraSoftwareButton")));
    }

}
