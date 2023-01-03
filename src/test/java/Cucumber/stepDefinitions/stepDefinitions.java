package Cucumber.stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

public class stepDefinitions {

    @Given("^User in on landing page$")
    public void user_in_on_landing_page() throws Throwable {
        System.out.println("testing1");
    }
    @When("User is on NetBanking landing page")
    public void userIsOnNetBankingLandingPage() {
        System.out.println("testing2");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        System.out.println("testing3");
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed() throws Throwable {
        System.out.println("testing4");
    }


}
