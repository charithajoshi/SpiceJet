package E2ESpicejet.Spicejet;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.CentralBanner;
import resources.BaseClass;

public class CentralBannerTests extends BaseClass{
	
	public WebDriver driver;
	CentralBanner bannobject;
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver = initialiseDriver();
		driver.get(prop.getProperty("url"));
		
		bannobject = new CentralBanner(driver);
		
	}
	
	@Test
	public void clickBanner() throws InterruptedException
	{
		bannobject.getBanner();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
