package ApplicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import GenericUtilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AppHooks {

	private WebDriver driver;
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	private Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.read_Prop();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(io.cucumber.java.Scenario scenario) {
		if(scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", screenShotName);
		}
	}
	
}
