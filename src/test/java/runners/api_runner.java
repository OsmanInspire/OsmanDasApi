package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber/report.json",
                "html:target/cucumber/report.html",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features/",
        glue = "stepDefs",
        dryRun = false,
        tags = "@db"
)
public class api_runner {
}
