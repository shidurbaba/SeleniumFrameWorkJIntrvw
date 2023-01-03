package Cucumber.Options;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(  monochrome = true,
        features = "src/test/java/Cucumber/feature/CucumberDemo.feature",
        dryRun = false,
        glue = "Cucumber.stepDefinitions")


public class TestRunner {
}
