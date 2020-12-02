package pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomePageSignUp {
	
	public WebDriver driver;
	
	public HomePageSignUp(WebDriver driver) //Constructor
	{
		this.driver = driver;
		
	}	
		
	//Login/SIGNUP
	By logSinup = By.xpath("//a[@id='ctl00_HyperLinkLogin']");
	By speMembers = By.xpath("//a[@id='ctl00_HyperLinkLogin']/following-sibling::ul/li[2]");
	By memLog = By.xpath("//a[@id='ctl00_HyperLinkLogin']/following-sibling::ul/li/ul/li[1]");
	By loginButton = By.xpath("//input[@type='submit']");	
	
	
	//LOGIN/SIGNUP;
	
	public void hoverLoginSignup() throws InterruptedException
	{
		WebElement hover = driver.findElement(logSinup);
		Actions act = new Actions(driver);
		act.moveToElement(hover).build().perform();
		
		WebElement specialMembers = driver.findElement(speMembers);
		act.moveToElement(specialMembers).build().perform();
		Thread.sleep(3000);
	}
	
	public WebElement clickMemberLogin() throws InterruptedException
	{			
		Actions act = new Actions(driver);
		WebElement memberLogin = driver.findElement(memLog);
		act.moveToElement(memberLogin).click().build().perform();
		return memberLogin;
	}	
	
	public WebElement getLoginBtn()
	{
		return driver.findElement(loginButton);
	}
}
