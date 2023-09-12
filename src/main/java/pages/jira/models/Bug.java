package pages.jira.models;

public class Bug {
    private String summary;
    private String description;

    public Bug() {
        setSummary();
        setDescription();
    }

    private void setSummary() {
        this.summary = "Checkout of a cart throws an exception when the payment method is Master card";
    }

    private void setDescription() {
        this.description = "Description\n" +
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
                "An exception is thrown";
    }

    public String getSummary() {
        return this.summary;
    }

    public String getDescription() {
        return this.description;
    }
}
