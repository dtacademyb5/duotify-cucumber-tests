package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

}
