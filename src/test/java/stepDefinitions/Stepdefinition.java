package stepDefinitions;


import org.openqa.selenium.By;
import org.testng.Assert;

import Baseclass.BaseClass;
import Testing.cucumber.FacebookPOM;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition extends BaseClass{
	@Given("^Initilize the browser with chrome$")
	public void initilize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		getBrowser("chrome");
		
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
		
	}

	  @When("^User enters (.+) and (.+)$")
	    public void user_enters_and(String username, String password) throws Throwable {
	    
		FacebookPOM fb=new FacebookPOM(driver);
		sendkeys(fb.getEmailid(), username);
		sendkeys(fb.getPwsd(), password);
		
		
	}

	@Then("^User click the login button$")
	public void user_click_the_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		FacebookPOM fb=new FacebookPOM(driver);
		click(fb.getLogin());
		

	}

	@Then("^Verify the user is Successfully logged in$")
	public void verify_the_user_is_Successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(getTitle());
		
	}

    @And("^close the browser$")
    public void close_the_browser() throws Throwable {
    	driver.quit();
    }

	
}