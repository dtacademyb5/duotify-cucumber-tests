package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtility;

import java.util.ArrayList;
import java.util.List;

public class DatabaseStepDefs {

    List<List<Object>> actualResult;

    @When("I send a query to get all playlists")
    public void i_send_a_query_to_get_all_playlists() {

        System.out.println("Sending query");
    }
    @Then("The result should be correct")
    public void the_result_should_be_correct() {

        System.out.println("Verify the result ");
    }



    @When("I send a query to get the first {int} users from users table")
    public void iSendAQueryToGetTheFirstUsersFromUsersTable(Integer count) {
       actualResult =
                DBUtility.getQueryResultAsListOfLists("select * from users limit "+count+"");


    }
    @Then("The result should be the following")
    public void theResultShouldBeTheFollowing(List<List<Object>> expectedResult) {

        for (int i = 0; i < expectedResult.size(); i++) {

            for (int j = 0; j < expectedResult.get(i).size(); j++) {
                Assert.assertEquals(expectedResult.get(i).get(j), String.valueOf(actualResult.get(i).get(j)));

            }

        }




    }

}
