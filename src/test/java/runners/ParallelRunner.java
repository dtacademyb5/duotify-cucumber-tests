package runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(



        features = "src/test/resources/features/parallel", // path where the feature files are located
         glue = "stepDefinitions" // path where the step Definition methods glued to feature file steps are located
//
//

        , plugin = {
                   "pretty",   // detailed test run results on the console
                   "html:target/built-in-html-report.html",  // generates built-in html report
                   "json:target/cucumber.json" , // generates a json report that is needed for pretty html report

                    },
        stepNotifications = true,   // shows detailed step results in report
        snippets = CucumberOptions.SnippetType.CAMELCASE  // generates snippets using camelCase



)
public class ParallelRunner {
}
