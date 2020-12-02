package E2ESpicejet.Spicejet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.BorderLinks;
import pageobjects.HomePageSignUp;
import resources.BaseClass;

public class BorderLinksTests extends BaseClass{

	public WebDriver driver;
	BorderLinks bordlinksobject;
	
	@BeforeTest
	public void initialise() throws IOException 
	{
		driver = initialiseDriver();
		bordlinksobject = new BorderLinks(driver);
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void openBorderLinks() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bordlinksobject.getBorder();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
