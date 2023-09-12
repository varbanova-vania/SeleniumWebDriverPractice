package pages.jira.models;

public class Story {

    private String summary;
    private String description;

    public Story() {
        setSummary();
        setDescription();
    }

    private void setSummary() {
        this.summary = "I'm testing Jira";
    }

    private void setDescription() {
        this.description = "As a user I want to test creating a story that bugs can be attached to.";
    }

    public String getSummary() {
        return this.summary;
    }

    public String getDescription() {
        return this.description;
    }
}
