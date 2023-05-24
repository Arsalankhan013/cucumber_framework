package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ApiWorkflow.feature",

        glue = "APIsteps",


        dryRun=false,
       //tags="@apidynamic",
        monochrome=true,

        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
                //this failed.txt file holds all the scenarios which are failed  during execution
                "rerun:target/failed.txt"}
)

public class APIRunner {
}
