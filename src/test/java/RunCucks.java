import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefinitions"}, dryRun = false,
        tags = " ",
        plugin = "json:build/cucumber-reports/cucumber.json")



public class RunCucks {

}