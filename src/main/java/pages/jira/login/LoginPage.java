package pages.jira.login;

import com.telerikacademy.testframework.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.jira.BasePage;

import static pages.jira.enums.ConfigKeys.*;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageToLoad() {

    }

    public void open() {
        driver.navigate().to(Utils.getConfigPropertyByKey(LOGIN_PAGE_URL.getKey()));
        logInButton().click();
    }

    public void enterLoginCredentials() {
        userActions.waitForElementVisible(Utils.getUIMappingByKey("jira.loginPage.usernameInputField"));
        usernameInputField().sendKeys(Utils.getConfigPropertyByKey("jira.loginCredentials.username"));
        continueButton().click();
        userActions.waitForElementVisible("jira.loginPage.userPasswordInputField");
        passwordInputField().sendKeys(Utils.getConfigPropertyByKey("jira.loginCredentials.password"));
        continueButton().click();
    }


    private WebElement logInButton() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.loginPage.logInButton")));
    }

    private WebElement continueButton() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.loginPage.continueButton")));
    }

    private WebElement usernameInputField() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.loginPage.usernameInputField")));
    }

    private WebElement passwordInputField() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.loginPage.userPasswordInputField")));
    }

}
