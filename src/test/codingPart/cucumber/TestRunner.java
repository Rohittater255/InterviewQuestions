package codingPart.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
        glue = "codingPart.cucumber.stepDefinitions",
        tags = "@Sanity or @Regression",
        plugin = {"pretty", "html:test-output/cucumber-reports.html"},
        monochrome = false,
        dryRun = false
        ,publish = true

)

public class TestRunner extends AbstractTestNGCucumberTests {


    //Below code is needed for parallel execution
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}