package stepDefinitions;

import com.mysql.cj.log.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import pages.LoginPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.DBUtility;
import utilities.Driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SignUpStepDefs {

    String username;
    String first;
    String last ;
    String email;
    String pass ;
    String expectedPassword;

    @Given("I am in homepage and click on sign up")
    public void iAmInHomepageAndClickOnSignUp() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().signUpLink.click();
    }
    @When("I fill up the fields with the following new user information")
    public void iFillUpTheFieldsWithTheFollowingNewUserInformation(List<Map<String, String>> dataTable) throws SQLException {

        username = dataTable.get(0).get("Username");
       first = dataTable.get(0).get("First Name");
        last = dataTable.get(0).get("Last Name");
        email = dataTable.get(0).get("Email");
         pass = dataTable.get(0).get("Password");
         expectedPassword = DigestUtils.md5Hex(pass);

        SignUpPage signUpPage = new SignUpPage();

        signUpPage.usernameField.sendKeys(username);
        signUpPage.firstName.sendKeys(first);
        signUpPage.lastName.sendKeys(last);
        signUpPage.email.sendKeys(email);
        signUpPage.email2.sendKeys(email);
        signUpPage.password.sendKeys(pass);
        signUpPage.password2.sendKeys(pass);
        signUpPage.registerButton.click();


    }
    @Then("This information should be stored correctly in the database")
    public void thisInformationShouldBeStoredCorrectlyInTheDatabase() throws SQLException {


        String query = "select username,firstName, lastName, email, password from users where username='"+username+"'";
        List<Map<String, Object>> queryResultListOfMaps = DBUtility.getQueryResultListOfMaps(query);
        Map<String, Object> map = queryResultListOfMaps.get(0);

        System.out.println(map);
//
        Assert.assertEquals(username, (String)(map.get("username")));
        Assert.assertEquals(first, (String)(map.get("firstName")));
        Assert.assertEquals(last, (String)(map.get("lastName")));
        Assert.assertEquals(email, ((String)(map.get("email"))).toLowerCase());
        Assert.assertEquals(expectedPassword, (String)(map.get("password")));


        DBUtility.updateQuery("delete from users where username='"+username+"'");  //to delete the created user to be able to run the script again




    }
}
