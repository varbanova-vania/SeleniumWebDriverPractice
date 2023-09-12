package test.cases.jira;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.jira.login.*;
import pages.jira.models.Story;

public class StoryTests extends BaseTest {
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
    public void storySuccessfullyCreated_when_fillRequiredFields() throws InterruptedException {
        Story story = new Story();
        boardPage.createStory(story);

        planingMenuPage.openStory(story);
        String actualStorySummary = planingMenuPage.actualTitleStoryResult().getText();
        String actualStoryDescription = planingMenuPage.actualDescriptionStoryResult().getText();
        Assertions.assertEquals(story.getSummary(), actualStorySummary, "Actual result is not as expected");
        Assertions.assertEquals(story.getDescription(), actualStoryDescription, "Actual result is not as expected");
    }

}
