package com.capgemini.capstore.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CustomerFeedbackStepDefinition {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();

	@Given("^customer has loaded the application in the browser$")
	public void customer_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^customer clicks on the login link$")
	public void customer_clicks_on_the_login_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^customer is navigated to login form page$")
	public void customer_is_navigated_to_login_form_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^customer enters valid email and valid password$")
	public void customer_enters_valid_email_and_valid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^customer should get navigated to customer home page$")
	public void customer_should_get_navigated_to_customer_home_page() throws Throwable {
		
	}

	@Given("^customer is on home page$")
	public void customer_is_on_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^customer clicks on give common feedback link$")
	public void customer_clicks_on_give_common_feedback_link() throws Throwable {
	    driver.findElement(By.xpath("//li[4]//a")).click();
	    
	}

	@Then("^customer is navigated to feedback form page$")
	public void customer_is_navigated_to_feedback_form_page() throws Throwable {
		String actual=driver.getCurrentUrl();
		String expected="http://localhost:4200/common-feedback-customer";
		Assert.assertEquals(actual,expected);
		Thread.sleep(2000);
	}

	@When("^customer enters feedback in the feedback textbox$")
	public void customer_enters_feedback_in_the_feedback_textbox() throws Throwable {
	    driver.findElement(By.name("feedback")).sendKeys("Good service");
		
	}

	@When("^customer selects brand name from the brand name drop down$")
	public void customer_selects_brand_name_from_the_brand_name_drop_down() throws Throwable {
		driver.findElement(By.name("brandname")).sendKeys("Adidas");
	}

	@When("^customer enters rating in the rating textbox$")
	public void customer_enters_rating_in_the_rating_textbox() throws Throwable {
		driver.findElement(By.name("rating")).sendKeys("3");
	}

	@When("^the customer clicks on Submit button$")
	public void the_customer_clicks_on_Submit_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	
	}

	@Then("^the customer home page must be displayed$")
	public void the_customer_home_page_must_be_displayed() throws Throwable {
	String actual=	driver.getCurrentUrl();
	String expected= "http://localhost:4200/";
	Assert.assertEquals(actual, expected);
	Thread.sleep(2000);

	}

	@Given("^the customer is in the order history details page$")
	public void the_customer_is_in_the_order_history_details_page() throws Throwable {
		String expected = "http://localhost:4200/orderhistory";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);

	}

	@When("^the customer clicks on feedback button$")
	public void the_customer_clicks_on_feedback_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-orderhistory/div/table/tbody/tr/td[8]//button")).click();
		
	}

	@Then("^the customer enters the rating in the rating textbox$")
	public void the_customer_enters_the_rating_in_the_rating_textbox() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/form/div[2]/input")).sendKeys("2");
	}

	@Then("^the customer enters the product feedback in the feedback textbox$")
	public void the_customer_enters_the_product_feedback_in_the_feedback_textbox() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/form/div[3]/input")).sendKeys("Poor quality");
	}

	@Then("^the customer clicks on submit button$")
	public void the_customer_clicks_on_submit_button() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/form/div[4]/button[2]")).click();
	}

	@Then("^the customer is redirected to customer home page$")
	public void the_customer_is_redirected_to_customer_home_page() throws Throwable {
		String actual=	driver.getCurrentUrl();
		String expected= "http://localhost:4200/";
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}
}
