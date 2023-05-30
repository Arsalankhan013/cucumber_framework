package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt",

glue="APIsteps",
        monochrome=true,

        plugin = {"pretty", "html:target2/cucumber.html", "json:target2/cucumber.json",
                //this failed.txt file holds all the scenarios which are failed  during execution
                "rerun:target/failed.txt"}
)

public class failedRunner {
}
