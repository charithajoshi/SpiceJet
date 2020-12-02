package E2ESpicejet.Spicejet;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SpiceClub;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import resources.BaseClass;

public class HomePageTest extends BaseClass{
	
	public WebDriver driver;
	public  HomePage hp;
	
	@BeforeTest
	public void intialise() throws IOException
	{
		driver=initialiseDriver();
		
		//driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void flightBooking() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hp = new HomePage(driver);
		//Select Rund trip radio button
		/*hp.getRoundTrip();
		//Click on the departure city	
		hp.getDeparture();
		//Select departure city
		hp.getDepartCity();
		//Select arrival city
		hp.getArrivalCity();
		Thread.sleep(2000);
		//Select departure date and month
		hp.getDepartureDate();		
		Thread.sleep(2000);
		//Select arrival date and month
		hp.getReturnDate();
		Thread.sleep(3000);
		//select passengers
		hp.getPassengers();
		Thread.sleep(3000);
		//adult passengers
		hp.getAdultPassengers();
		//child passengers
		hp.getChildPassengers();
		//infant passengers
		hp.getInfantPassengers();
		Thread.sleep(3000);
				
		//Select family and friends checkbox
		//hp.getFamilyAndFriends();
		hp.getCheckBoxes();
		Thread.sleep(3000);
		
		hp.getSpecialAssistance();
		Thread.sleep(2000);
		
		Thread.sleep(3000);
		hp.getBanner();*/
		
		//Click Search button
		//hp.getSearch();
		
	}
	
	@Test
	public void openBorderLinks() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hp.getBorder();
	}
	
	
	
	//SpiceClub Login Page
	//@Test(dataProvider = "getData")
	public void spiceClubLogin(String uname, String pwd) throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		//Login/Signup
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hp.getLoginSignup();
		Thread.sleep(3000);
		SpiceClub sc = new SpiceClub(driver);
		Thread.sleep(3000);
		sc.getSCUserName().sendKeys(uname);
		Thread.sleep(3000);
		sc.getSCPassword().sendKeys(pwd);
	}
		
		
	
	@AfterTest
	public void teardown()
	{
		
//		Set<String> win = driver.getWindowHandles();
//		Iterator<String> it= win.iterator();
//		String parent_window = it.next();
//		String child_window = it.next();
//		driver.switchTo().window(child_window);
//		System.out.println(driver.getTitle());
		
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
