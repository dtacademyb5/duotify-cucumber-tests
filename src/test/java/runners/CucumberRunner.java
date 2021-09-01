package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        tags = "@loginScenarios",   // "@login or @smoke", "@login and @smoke", "@login and not @smoke", "@login and @smoke and @regression"
        features = "src/test/resources/features", // path where the feature files are located
        glue = "stepDefinitions" // path where the stepDefinitions glued to steps are located
//        ,dryRun = true    // this is used to generate step definition snippets without actually running the test


)
public class CucumberRunner {
}
