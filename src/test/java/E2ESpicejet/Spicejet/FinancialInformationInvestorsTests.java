package E2ESpicejet.Spicejet;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePageSignUp;
import pageobjects.InvestorsFinancialInformation;
import resources.BaseClass;

public class FinancialInformationInvestorsTests extends BaseClass {
	
	public WebDriver driver;
	public InvestorsFinancialInformation fininfoobject;
	public  HomePageSignUp hp;
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver = initialiseDriver();
		driver.get(prop.getProperty("url"));
		fininfoobject = new InvestorsFinancialInformation(driver);
		
		
	}
	
	@Test
	public void readAnnualReports() throws InterruptedException
	{
		fininfoobject.clickFinancialInformation();
		Thread.sleep(3000);
		fininfoobject.getAnnualReports();
		Thread.sleep(3000);
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
