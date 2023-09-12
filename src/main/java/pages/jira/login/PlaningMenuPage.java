package pages.jira.login;

import com.telerikacademy.testframework.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.jira.BasePage;
import pages.jira.models.Bug;
import pages.jira.models.Story;

public class PlaningMenuPage extends BasePage {
    public PlaningMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageToLoad() {
            userActions.waitForElementVisible(Utils.getUIMappingByKey("jira.planning.contentContainer"));
    }
    public void openBacklog() throws InterruptedException {
      addBacklogButton().click();
        waitForPageToLoad();
        Thread.sleep(10000);
//        backlogDropDown().click();
        openStoryBySummary("I'm testing Jira").click();
        userActions.waitForElementVisible(Utils.getUIMappingByKey("jira.planing.linkedContainer"));
        openLinkButton().click();
        Thread.sleep(3000);
        checkLinkIssueButton().click();
        Thread.sleep(3000);
        checkLinkedIssuesType().click();
        Thread.sleep(3000);
        searchField().click();
        Thread.sleep(3000);
        openIssueBySummary().click();
        Thread.sleep(3000);
        linkIssueWithStoryButton().click();
        System.out.println();
    }

    public void openStory(Story story) throws InterruptedException {
        addBacklogButton().click();
        waitForPageToLoad();
        Thread.sleep(10000);
        var element = openStoryBySummary(story.getSummary());
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        Thread.sleep(4000);
    }
    public void openBug(Bug bug) throws InterruptedException {
        addBacklogButton().click();
        waitForPageToLoad();
        Thread.sleep(10000);
        var element = openBugBySummary(bug.getSummary());
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        Thread.sleep(4000);
    }

    private WebElement addBacklogButton() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.planing.backlogField")));
    }
    private WebElement linkedContainer(){
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.planing.linkedContainer")));
    }
    private WebElement backlogDropDown(){
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.planing.backlogDropDown")));
    }
    private WebElement openIssueBySummary(){
        var xpath = "//div[contains(@class,  'menu-list')]//child::span[contains(text(), ' Checkout of a cart throws an exception when the payment method is Master card')]";
        return driver.findElement(By.xpath(xpath));
    }
    private WebElement openLinkButton(){
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.planing.linkButton")));
    }
    private WebElement checkLinkIssueButton(){
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.planing.linkIssue")));
            }
    private WebElement checkLinkedIssuesType(){
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.planing.linkedIssuesType")));
    }
    private WebElement searchField(){
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.planing.searchField")));
    }
    private WebElement openStoryBySummary(String summary){
        String xpath = String.format(Utils.getUIMappingByKey("jira.planing.clickStory"), summary);
        return driver.findElement(By.xpath(xpath));
    }
    private WebElement openBugBySummary(String summary){
        String xpath = String.format(Utils.getUIMappingByKey("jira.planing.clickBug"), summary);
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement linkIssueWithStoryButton(){
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.planing.linkIssueWithStoryButton")));
    }

    private WebElement contentContainer(){
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.planning.contentContainer")));
    }
    public WebElement actualTitleStoryResult() {
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.actualTitleStoryResult")));
    }

    public WebElement actualDescriptionStoryResult(){
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.actualDescriptionStoryResult")));
    }
    public WebElement blockedResult(){
        return driver.findElement(By.xpath(Utils.getUIMappingByKey("jira.blocked")));
    }
}
