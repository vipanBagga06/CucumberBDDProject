package ApplicationPages;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	
	By headerLinks = By.cssSelector("div#navbar-collapse a");
	By userNameField = By.name("username");
	By passwordField = By.name("password");
	By loginButton = By.xpath("//input[@value='Login']");
	By userNameLabel = By.xpath("//td[contains(text(),'group automation')]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public List<String> getLoginPageHeader() {
		List<String> list = new ArrayList();
		List<WebElement> fetched_List = driver.findElements(headerLinks);
		for(WebElement e : fetched_List) {
			String l = e.getText();
			list.add(l);
		}
		return list;
	}
	
	public void inputUserName(String uname) {
		driver.findElement(userNameField).sendKeys(uname);
	}
	
	public void inputPassword(String pwd) {
		driver.findElement(passwordField).sendKeys(pwd);
	}
	
	public void clickLoginButton( ) {
		driver.findElement(loginButton).click();
	}
	
	public boolean getUserNameLabelOnHomePage() {
		driver.switchTo().frame("mainpanel");
		return driver.findElement(userNameLabel).isDisplayed();
	}
	
}
