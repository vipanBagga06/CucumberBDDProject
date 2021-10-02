package ApplicationRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/vipan/eclipse-workspace/cucumberPracticeFreeCRMProject2021/"
				+ "src/test/resources/ApplicationFeatures",
		glue = {"Stepdefinitions","ApplicationHooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"},
		monochrome = true,
		publish = true
		)
public class AppRunner {

}
