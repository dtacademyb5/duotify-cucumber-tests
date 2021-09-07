package stepDefinitions;


import com.mysql.cj.log.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.sql.SQLOutput;

public class LoginStepDefs {


    String url = ConfigReader.getProperty("url");

    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage() {
        System.out.println("Background");
        Driver.getDriver().get(url);

    }
    @When("The user enters the valid credentials")
    public void the_user_enters_the_valid_credentials() {
        System.out.println("Sceanrio");
         new LoginPage().login(ConfigReader.getProperty("username1"), ConfigReader.getProperty("password1"));

    }

    @Then("The user should be able to login and land on the homepage")
    public void the_user_should_be_able_to_login_and_land_on_the_homepage() {


        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));



    }




    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
       new LoginPage().login("duotech", "duotech");
    }
    @Then("the user should not be able to login and get an error message")
    public void the_user_should_not_be_able_to_login_and_get_an_error_message() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("url")));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Your username or password was incorrect"));

    }


    @When("the user enters empty credentials")
    public void the_user_enters_empty_credentials() {
        new LoginPage().login("", "");
    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("url")));

    }

    @When("the user enters valid username and invalid password")
    public void the_user_enters_valid_username_and_invalid_password() {
        new LoginPage().login(ConfigReader.getProperty("username1"), "cshbdjgvdbchdbsdvjgcsdv");
    }

    @When("The user enters the valid credentials as duotech for username and duotech for password")
    public void theUserEntersTheValidCredentialsAsDuotechForUsernameAndDuotechForPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The user enters the valid credentials as {string} for username and {string} for password")
    public void theUserEntersTheValidCredentialsAsForUsernameAndForPassword(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }



    @When("I send a query {string} and the id {int} also price {double}")
    public void iSendAQueryAndTheIdAlsoPrice(String query, Integer amount, Double price) {


        System.out.println(query);
        System.out.println(amount);
        System.out.println(price);
    }


}
