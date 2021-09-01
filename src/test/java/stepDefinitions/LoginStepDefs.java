package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepDefs {


    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @When("The user enters the valid credentials")
    public void the_user_enters_the_valid_credentials() {

         new LoginPage().login(ConfigReader.getProperty("username1"), ConfigReader.getProperty("password1"));

    }

    @Then("The user should be able to login and land on the homepage")
    public void the_user_should_be_able_to_login_and_land_on_the_homepage() {


        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));

        Driver.quitDriver();

    }
}
