package DriverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdlocal = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		System.out.println("Browser name is>>>"+browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tdlocal.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tdlocal.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			tdlocal.set(new SafariDriver());
		}
		else
		{
			System.out.println("Incorrect browser passed>>>"+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdlocal.get();
	}
}
