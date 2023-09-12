package pages.jira.login;

import com.telerikacademy.testframework.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.jira.BasePage;
import pages.jira.models.Bug;
import pages.jira.models.Story;


public class BoardPage extends BasePage {
    public BoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageToLoad() {
        userActions.waitForElementPresent("jira.boardPage.createButton");
        userActions.waitForElementVisible("jira.boardPage.createButton");
        userActions.waitForElementClickable("jira.boardPage.createButton");
    }

    public void openStory() throws InterruptedException {
        waitForPageToLoad();
        createButton().click();
        userActions.waitForElementVisible("jira.boardPage.issueContainer");
        Thread.sleep(5000);

        summaryInputField().sendKeys("I'm testing Jira");
        descriptionTextArea().sendKeys("As a user I want to test creating a story that bugs can be attached to.");
        createStoryButton().click();
    }

    public void createStory(Story story) throws InterruptedException {
        waitForPageToLoad();
        createButton().click();
        userActions.waitForElementVisible("jira.boardPage.issueContainer");
        Thread.sleep(5000);

        summaryInputField().sendKeys(story.getSummary());
        descriptionTextArea().sendKeys(story.getDescription());
        createStoryButton().click();
    }

    public void openBug() throws InterruptedException {
        waitForPageToLoad();
        createButton().click();
        userActions.waitForElementVisible("jira.boardPage.issueContainer");
        Thread.sleep(5000);
        issueTypeDropdown().click();
        Thread.sleep(5000);

        selectIssueTypeByText("Bug").click();
        Thread.sleep(5000);
        summaryInputField().sendKeys("Checkout of a cart throws an exception when the payment method is Master card");
        descriptionTextArea().sendKeys("Description\n" +
                "Checkout of a cart throws an exception when the payment method is Master card. See attached image.\n" +
                "\n" +
                "Steps to reproduce\n" +
                "Navigate to the login page\n" +
                "\n" +
                "Log in\n" +
                "\n" +
                "Go to products, search, choose and add one to the cart\n" +
                "\n" +
                "Go to the cart and press checkout\n" +
                "\n" +
                "Select a payment method Credit Card -> Master Card\n" +
                "\n" +
                "Click checkout\n" +
                "\n" +
                "Expected result\n" +
                "You are redirected to the payment pop-up\n" +
                "\n" +
                "Actual result\n" +
                "An exception is thrown");

//        Actions actions = new Actions(driver);
//        actions.moveToElement(priorityTypeDropdown());
//        actions.perform();
//        priorityTypeDropdown().click();
//        Thread.sleep(5000);
//        selectPriorityTypeByText("High").click();
        createStoryButton().click();
        Thread.sleep(4000);
    }
    public void createBug(Bug bug) throws InterruptedException {
        waitForPageToLoad();
        createButton().click();
        userActions.waitForElementVisible("jira.boardPage.issueContainer");
        Thread.sleep(5000);
        issueTypeDropdown().click();
        Thread.sleep(5000);
        selectIssueTypeByText("Bug").click();
        Thread.sleep(5000);

        summaryInputField().sendKeys(bug.getSummary());
        descriptionTextArea().sendKeys(bug.getDescription());
        createStoryButton().click();
    }

    private WebElement createButton() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.boardPage.createButton")));
    }

    private WebElement summaryInputField() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.boardPage.summaryInputField")));
    }

    private WebElement descriptionTextArea() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.boardPage.descriptionTextArea")));
    }

    private WebElement createStoryButton() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.boardPage.createStoryButton")));
    }

    private WebElement issueTypeDropdown() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.boardPage.issueTypeDropDown")));
    }

    private WebElement selectIssueTypeByText(String issueType) {
        var xpath = String.format(Utils.getUIMappingByKey("jira.boardPage.issueTypesValue"), issueType);
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement priorityTypeDropdown() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.boardPage.priorityDropDown")));
    }

    private WebElement selectPriorityTypeByText(String priorityType) {
        var xpath = String.format(Utils.getUIMappingByKey("jira.boardPage.priorityTypesValue"), priorityType);
        return driver.findElement(By.xpath(xpath));
    }

}
