package runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = "@target/failed-scenarios.txt", // path where the feature files are located
        glue = "stepDefinitions"




)
public class FailedScenariosRunner {
}
