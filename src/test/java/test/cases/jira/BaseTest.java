package test.cases.jira;

import com.telerikacademy.testframework.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {
    protected UserActions userActions = new UserActions();

    @BeforeClass
    public static void setUp() {
        UserActions.loadBrowser("jira.homePage");
    }
    @AfterClass
    public static void tearDown() {
        UserActions.quitDriver();
    }
}
