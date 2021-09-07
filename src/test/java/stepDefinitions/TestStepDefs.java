package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class TestStepDefs {

    @Given("I have set up all the pre-conditions for the test")
    public void i_have_set_up_all_the_pre_conditions_for_the_test() {
        System.out.println("Given step");
    }
    @When("I execute a specific step")
    public void i_execute_a_specific_step() {
        System.out.println("When step");

    }
    @Then("The result should be as expected")
    public void the_result_should_be_as_expected() {
        System.out.println("Then step");
    }
    @Then("The result should also have this outcome")
    public void the_result_should_also_have_this_outcome() {
        System.out.println("And step");
    }
    @Then("The result should also should contain this outcome")
    public void the_result_should_also_should_contain_this_outcome() {
        System.out.println("And step");
    }
    @Then("The result should not contain this outcome")
    public void the_result_should_not_contain_this_outcome() {
        System.out.println("But step");
    }


    @When("the user passes this information")
    public void theUserPassesThisInformation(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
    }
    @Then("It should passed correctly")
    public void itShouldPassedCorrectly() {

    }


    @When("the user passes this information as a table")
    public void theUserPassesThisInformationAsATable(List<List<Object>> dataTable) {
        System.out.println(dataTable);
    }


    @When("the user passes this information as a table as a map")
    public void theUserPassesThisInformationAsATableAsAMap(List<Map<String, Object>> dataTable) {
        System.out.println(dataTable);
    }


    @When("the user passes this information as a table as a map of string and list")
    public void theUserPassesThisInformationAsATableAsAMapOfStringAndList(Map<String, List<String>> dataTable) {
        System.out.println(dataTable);
    }


    @When("the user passes this information as a table as a map of maps")
    public void theUserPassesThisInformationAsATableAsAMapOfMaps(Map<String, Map<String,String>> dataTable) {
        System.out.println(dataTable);
    }


    @Given("I have all the preresuisites")
    public void iHaveAllThePreresuisites() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I navigate to a {string} page")
    public void iNavigateToAPage(String pageName) {

    }
    @Then("The page title should be {string} and api request should return {string}")
    public void thePageTitleShouldBeAndApiRequestShouldReturn(String title, String status) {

    }



}
