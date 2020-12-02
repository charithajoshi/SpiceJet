package E2ESpicejet.Spicejet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePageSignUp;
import pageobjects.SpiceClub;
import resources.BaseClass;

public class LoginSignUpTests extends BaseClass {
	
	public WebDriver driver;
	HomePageSignUp homesingupobject;
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver=initialiseDriver();
		driver.get(prop.getProperty("url"));
		homesingupobject = new HomePageSignUp(driver);
	}
	
	
	//SpiceClub Login Page
	@Test(dataProvider = "getData")
	public void spiceClubLogin(String uname, String pwd) throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		//Login/Signup
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homesingupobject.hoverLoginSignup();
		homesingupobject.clickMemberLogin();
		Thread.sleep(3000);
		SpiceClub sc = new SpiceClub(driver);
		Thread.sleep(3000);
		sc.getSCUserName().sendKeys(uname);
		Thread.sleep(3000);
		sc.getSCPassword().sendKeys(pwd);
		}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "7208935924";
		data[0][1] = "password";
		
		data[1][0] = "charithats@gmail.com";
		data[1][1] = "spicejet";
		
		return data;
		
	}
}
