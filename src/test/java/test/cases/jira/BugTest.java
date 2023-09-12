package test.cases.jira;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.jira.login.*;
import pages.jira.models.Bug;

public class BugTest extends BaseTest {
    private LoginPage loginPage;
    private StartPage startPage;
    private ProjectsPage projectsPage;
    private BoardPage boardPage;
    private PlaningMenuPage planingMenuPage;

    @Before
    public void beforeEach() throws InterruptedException {
        loginPage = new LoginPage(userActions.getDriver());
        startPage = new StartPage(userActions.getDriver());
        projectsPage = new ProjectsPage(userActions.getDriver());
        boardPage = new BoardPage(userActions.getDriver());
        planingMenuPage = new PlaningMenuPage(userActions.getDriver());

        loginPage.open();
        loginPage.enterLoginCredentials();
        startPage.openJiraSoftware();
        projectsPage.createNewProject();
    }

    @Test
    public void bugSuccessfullyCreated_when_fillRequiredFields() throws InterruptedException {
        Bug bug = new Bug();
        boardPage.createBug(bug);

        planingMenuPage.openBug(bug);
        String actualBugSummary = planingMenuPage.actualTitleStoryResult().getText();
        Assertions.assertEquals(bug.getSummary(), actualBugSummary, "Actual result is not as expected");
        Assertions.assertTrue(planingMenuPage.actualDescriptionStoryResult().isDisplayed());
    }
}
