package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpiceClub {
	
	public WebDriver driver;
	
	public SpiceClub(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By scMemberID= By.cssSelector("input[name*='TextBoxUserID']");
	By scPassword = By.cssSelector("input[id*='PasswordFieldPassword']");
	
	public WebElement getSCUserName()
	{
		return driver.findElement(scMemberID);
	}
	
	public WebElement getSCPassword()
	{
		return driver.findElement(scPassword);
	}

}
