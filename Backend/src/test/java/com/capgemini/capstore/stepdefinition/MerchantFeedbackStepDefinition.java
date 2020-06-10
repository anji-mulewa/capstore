package com.capgemini.capstore.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MerchantFeedbackStepDefinition {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	
	@Given("^merchant has loaded the application in the browser$")
	public void merchant_has_loaded_the_application_in_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^merchant clicks on the login link$")
	public void merchant_clicks_on_the_login_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^merchant is navigated to login form page$")
	public void merchant_is_navigated_to_login_form_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^merchant enters valid email and valid password$")
	public void merchant_enters_valid_email_and_valid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^merchant clicks on login button$")
	public void merchant_clicks_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^merchant should get navigated to customer home page$")
	public void merchant_should_get_navigated_to_customer_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the merchant is on the merchant home page$")
	public void the_merchant_is_on_the_merchant_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the merchant clicks on see common feedback link$")
	public void the_merchant_clicks_on_see_common_feedback_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the merchant is redirected to common feedback table page$")
	public void the_merchant_is_redirected_to_common_feedback_table_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
