package StepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.HomePageSignUp;
import pageobjects.SpiceClub;
import resources.BaseClass;

public class LoginStepDefinition extends BaseClass {
	 public HomePageSignUp homesingupobject;
	
	 @Given("^Initialise the browser with Chrome$")
	    public void initialise_the_browser_with_chrome() throws Throwable {
		 driver = initialiseDriver();
	    }
	 	
	 	@And("^Navigate to \"([^\"]*)\" website$")
	    public void navigate_to_something_website(String strArg1) throws Throwable {
	 		driver.get(strArg1);
	    }

	 	@And("^Hover the mouse on the LOGIN/SIGNUP$")
		public void hover_the_mouse_on_the_loginsignup() throws Throwable {
	 		homesingupobject = new HomePageSignUp(driver);
	 		homesingupobject.hoverLoginSignup();
	 	}
	 	 
	 	@When("^Click on Member Login$")
	    public void click_on_member_login() throws Throwable {
	 		homesingupobject = new HomePageSignUp(driver);
	 		homesingupobject.clickMemberLogin();
	    }
	 		        
	    @Then("^User enters (.+) and (.+)$")
	    public void user_enters_and(String username, String password) throws Throwable {
	    	SpiceClub sc = new SpiceClub(driver);
	    	sc.getSCUserName().sendKeys(username);
	    	sc.getSCUserName().sendKeys(password);
	    	
	    }
	    
	    @And("^Check if login button is displayed$")
	    public void check_if_login_button_is_displayed() throws Throwable {
	    	homesingupobject = new HomePageSignUp(driver);
	    	Boolean flag = homesingupobject.getLoginBtn().isDisplayed();
	    	Assert.assertTrue(flag);
	    }

	    
	    @And("^Close browsers$")
	    public void close_browsers() throws Throwable {
	    	driver.quit();
	    }

}
