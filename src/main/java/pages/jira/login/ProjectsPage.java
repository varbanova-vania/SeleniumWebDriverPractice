package pages.jira.login;

import com.telerikacademy.testframework.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.jira.BasePage;

import static pages.jira.enums.ConfigKeys.*;


public class ProjectsPage extends BasePage {
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageToLoad() {
        userActions.waitForElementClickable("jira.projectPage.createButton");
    }

    public void createNewProject() throws InterruptedException {
        waitForPageToLoad();
        newProjectButton().click();
        userActions.waitForElementClickable("jira.projectPage.addTemplates");
        addProjectTemplates().click();
        userActions.waitForElementClickable("jira.projectPage.useTemplateButton");
        useTemplate().click();
        userActions.waitForElementClickable("jira.projectPage.chooseProjectType");
        chooseProjectType().click();
        userActions.waitForElementVisible("jira.projectPage.addNameToInputField");
        addNameToInputField().sendKeys(givenRandomName());
        Thread.sleep(5000);
        userActions.waitForElementVisible("jira.projectPage.keyField");
        submitProjectButton().click();
        Thread.sleep(10000);
    }

    private WebElement newProjectButton() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.projectPage.createButton")));
    }

    private WebElement addProjectTemplates() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.projectPage.addTemplates")));
    }

    private WebElement useTemplate() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.projectPage.useTemplateButton")));
    }

    private WebElement chooseProjectType() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.projectPage.chooseProjectType")));
    }

    private WebElement addNameToInputField() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.projectPage.addNameToInputField")));
    }

    private WebElement keyField() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.projectPage.keyField")));
    }

    private WebElement submitProjectButton() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.projectPage.submitProjectButton")));
    }

    public String givenRandomName() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumber = false;
        String generateName = RandomStringUtils.random(length, useLetters, useNumber);
        return generateName;

    }


}
