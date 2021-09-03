package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtility;

public class DatabaseStepDefs {


    @When("I send a query to get all playlists")
    public void i_send_a_query_to_get_all_playlists() {

        System.out.println("Sending query");
    }
    @Then("The result should be correct")
    public void the_result_should_be_correct() {

        System.out.println("Verify the result ");
    }

}
