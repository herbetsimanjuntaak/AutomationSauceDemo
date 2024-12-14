package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/saucedemo/cucumber-report.json",  "html:target/results/saucedemo/index.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@Test"

)
public class SaucedemoTestRunner extends BaseTestRunner
{

}
