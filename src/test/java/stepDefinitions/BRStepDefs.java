package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AlbumPage;
import pages.BrowsePage;
import pages.LoginPage;
import utilities.DBUtility;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class BRStepDefs {

    String actualArtistName;
    Integer beforeCount;
    Integer expectedCount;
    List<Object> actualGenres;

    @Given("I am logged in using {string} and {string}")
    public void iAmLoggedInUsingAnd(String username, String pass) {

        new LoginPage().login(username, pass);

    }
    @When("I retrieve details for album {string}")
    public void iRetrieveDetailsForAlbum(String album) {
        new BrowsePage().clickOnAlbum(album);
        actualArtistName = new AlbumPage().artistName.getText().substring(3);


    }

    @Then("The album artist name should be {string}")
    public void theAlbumArtistNameShouldBe(String expectedArtistName) {
        Assert.assertEquals(expectedArtistName, actualArtistName);
    }

    @When("I click on the song {string} from the album {string} {int} times")
    public void iClickOnTheSongTimes(String songName, String albumName, Integer timesPlayed) throws InterruptedException {
       beforeCount = (Integer)(DBUtility.getQueryResultAsListOfLists("select plays from songs where id='3'").get(0).get(0));
       new BrowsePage().clickOnAlbum(albumName);

        for (int i = 0; i < timesPlayed; i++) {
            SeleniumUtils.jsClick(new AlbumPage().playButton);
            Thread.sleep(100);
        }

       expectedCount = timesPlayed;

    }
    @Then("The plays should be incremented accordingly in the db")
    public void thePlaysShouldBeIncrementedAccordinglyInTheDb() {
        int afterCount = (Integer)(DBUtility.getQueryResultAsListOfLists("select plays from songs where id='3'").get(0).get(0));
        int actualCount = afterCount - beforeCount;
        Assert.assertEquals(expectedCount, Integer.valueOf(actualCount));
    }

    @When("I send an insert query to insert a new user")
    public void iSendAnInsertQueryToInsertANewUser(String docString) {
        System.out.println(docString);
    }
    @Then("The user should be inserted into the database")
    public void theUserShouldBeInsertedIntoTheDatabase() {

    }

    @When("I send a query to retrieve genres from the db")
    public void iSendAQueryToRetrieveGenresFromTheDb() {
        List<List<Object>> list = DBUtility.getQueryResultAsListOfLists("select name from genres");

        actualGenres = new ArrayList<>();
        for (List<Object> row : list) {
            actualGenres.add(row.get(0));
        }


    }
//    @Then("The result should contain the following genres")
//    public void theResultShouldContainTheFollowingGenres(List<Object> expectedGenres) {
//        Assert.assertEquals(expectedGenres, actualGenres);
//
//    }

















}
