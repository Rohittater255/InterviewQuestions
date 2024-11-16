package test.codingPart.cucumber.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {

    @Given("User is logged in the application")
    public void user_is_logged_in_the_application() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is logged in the system");
    }

    @Given("User navigates to search page")
    public void user_navigates_to_search_page() {
        System.out.println("User navigate to search page");
    }

    @When("User searches {string}")
    public void user_searches(String string) {
        System.out.println("User searches:- " + string);
    }

    @When("clicks on search button")
    public void clicks_on_search_button() {
        System.out.println("clicks on search button ");
    }

    @Then("{string} phones should be shown to the user")
    public void phones_should_be_shown_to_the_user(String string) {
        System.out.println(string + " clicks on search button ");
    }

}
