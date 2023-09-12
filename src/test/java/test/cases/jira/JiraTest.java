package test.cases.jira;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.jira.login.*;

public class JiraTest extends BaseTest {
    private LoginPage loginPage;
    private StartPage startPage;
    private ProjectsPage projectsPage;
    private BoardPage boardPage;
    private PlaningMenuPage planingMenuPage;

    @Before
    public void testSetup() throws InterruptedException {
        loginPage = new LoginPage(userActions.getDriver());
        startPage = new StartPage(userActions.getDriver());
        projectsPage = new ProjectsPage(userActions.getDriver());
        boardPage = new BoardPage(userActions.getDriver());
        planingMenuPage = new PlaningMenuPage(userActions.getDriver());

        loginPage.open();
        loginPage.enterLoginCredentials();
        startPage.openJiraSoftware();
        projectsPage.createNewProject();
        boardPage.openStory();
        boardPage.openBug();
        planingMenuPage.openBacklog();
    }

    @Test
    public void testMethod() {
        Assert.assertTrue(true);
    }


    @Test
    public void  storyIsBlockedByIssue_when_fillRequiredFieldsStoryAndIssue (){
        var result= planingMenuPage.blockedResult();
        Assertions.assertNotNull(result);
    }

}
