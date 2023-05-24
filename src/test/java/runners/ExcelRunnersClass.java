package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the features file
        features = "src/test/resources/features/AddEmployee.feature",
        //features = "src/test/resources/features/Login.feature",
        //glue is where we find implementations for gherkin steps
        //we provide the path of package where we defined all the steps
        glue = "steps",


        dryRun=false,
tags="@excel",
        monochrome=true,

        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
        //this failed.txt file holds all the scenarios which are failed  during execution
        "rerun:target/failed.txt"}
)



public class ExcelRunnersClass {
}
