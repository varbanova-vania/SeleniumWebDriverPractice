package pages.jira.enums;

public enum ConfigKeys {

    LOGIN_PAGE_URL("jira.homePage") ,
    START_PAGE_URL("jira.StartPage "),
    PROJECT_PAGE_URL("jira.ProjectPage"),
    BOARD_PAGE_URL("jira.BoardPage");



    private final String key;

    ConfigKeys(String key) {
        this.key = key;
    }
    public String getKey(){
        return key;
    }
}
