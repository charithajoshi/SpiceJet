package E2ESpicejet.Spicejet;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.FooterLinks;
import pageobjects.HomePageSignUp;
import resources.BaseClass;

public class FooterLinksTests extends BaseClass{

	FooterLinks footlinksobject;
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver = initialiseDriver();
		driver.get(prop.getProperty("url"));
		footlinksobject=new FooterLinks(driver);
	}
	
	@Test
	public void clickFooterLinks() throws InterruptedException
	{
		footlinksobject.getFooterLinks();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
