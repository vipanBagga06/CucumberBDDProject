package Stepdefinitions;

import java.util.List;

import org.testng.Assert;

import ApplicationPages.LoginPage;
import DriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("User is on Free CRM Application Login Page")
	public void user_is_on_free_crm_application_login_page() {
		DriverFactory.getDriver().get("https://classic.freecrm.com/index.html");
	}

	@Then("title of the page should be {string}")
	public void title_of_the_page_should_be(String title) {
	    String expectedTitle = loginPage.getLoginPageTitle();
	    Assert.assertEquals(title, expectedTitle);
	}

	@Then("Following Page Headers should be displayed on Login Page")
	public void following_page_headers_should_be_displayed_on_login_page(io.cucumber.datatable.DataTable pageHeaders) {
	    List<String> expectedList = pageHeaders.asList();
	    List<String> actualList = loginPage.getLoginPageHeader();
	    Assert.assertTrue(expectedList.containsAll(actualList));
	}

	@When("User enters the username as {string}")
	public void user_enters_the_username_as(String username) {
		loginPage.inputUserName(username);
	}

	@When("User enters the password as {string}")
	public void user_enters_the_password_as(String password) {
		loginPage.inputPassword(password);
	}

	@When("User clicks on the Login Button")
	public void user_clicks_on_the_login_button() {
	    loginPage.clickLoginButton();
	}

	@Then("User is navigated to the Home Page successfully")
	public void user_is_navigated_to_the_home_page_successfully() {
	    boolean flag = loginPage.getUserNameLabelOnHomePage();
	    Assert.assertTrue(flag);
	}
	
	
}
