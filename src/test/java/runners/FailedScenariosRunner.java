package runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = "@target/failed-scenarios.txt", // path where the text file with failed scenarios list is located
        glue = "stepDefinitions"




)
public class FailedScenariosRunner {
}
