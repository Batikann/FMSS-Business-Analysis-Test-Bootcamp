package cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "steps",
        //tags = "@tag1 or @tag2 or @tag3"
        tags = "@appium or @smoke or @e2e or @happypath"
)

public class RunCucumberTests {

}