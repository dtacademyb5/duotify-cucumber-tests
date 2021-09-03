package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        tags = "@loginInvalid",   // "@login or @smoke", "@login and @smoke", "@login and not @smoke", "@login and @smoke and @regression"
        features = "src/test/resources/features", // path where the feature files are located
        glue = "stepDefinitions" // path where the step Definition methods glued to feature file steps are located
//        ,dryRun = true    // this is used to generate step definition snippets without actually running the test
        , plugin = {
                  "html:target/built-in-html-report.html"
                    }


)
public class CucumberRunner {
}
