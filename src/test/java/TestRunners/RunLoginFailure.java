package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/LoginFailure/"},
        glue = {"StepDefinitions/LoginFailure"}
)

public class RunLoginFailure {
}
