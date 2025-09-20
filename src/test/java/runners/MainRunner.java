package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
                glue = "org.selenium.architecture.stepsdefs",
                //plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json"},
                plugin = {
                        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                },
                monochrome = true,
                publish = true
)
public class MainRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
