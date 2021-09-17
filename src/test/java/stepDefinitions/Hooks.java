package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DBUtility;
import utilities.Driver;

import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;

public class Hooks {

    @Before    //@Before ("not @db_only")
    public void setupScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().window().maximize();


    }


    @Before ("@db_only")
    public void setupDb(){
        DBUtility.createConnection();
    }

    @After ("@db_only")
    public void tearDownDb(){
        DBUtility.close();
    }


    @After
    public void tearDownScenario(Scenario scenario){
         if(scenario.isFailed()){
             byte[] screenshotAs = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
             scenario.attach(screenshotAs, "image/png" , "failedScreenshot");
         }


        Driver.quitDriver();

    }
}
