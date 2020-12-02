package E2ESpicejet.Spicejet;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.FlightSearch;
import pageobjects.HomePageSignUp;
import pageobjects.SpiceClub;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import resources.BaseClass;

public class FlightSearchTests extends BaseClass{
	
	public WebDriver driver;
	public  FlightSearch flisearchobject;
	
	@BeforeTest
	public void intialise() throws IOException
	{

		driver=initialiseDriver();
		flisearchobject = new FlightSearch(driver);		
	}
	
	@Test
	public void flightBooking() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Select Round trip radio button
		flisearchobject.getRoundTrip();
		Thread.sleep(2000);
		//Click on the departure city	
		flisearchobject.getDeparture();
		Thread.sleep(2000);
		//Select departure city
		flisearchobject.getDepartCity();
		Thread.sleep(2000);
		//Select arrival city
		flisearchobject.getArrivalCity();
		Thread.sleep(2000);
		//Select departure date and month
		flisearchobject.getDepartureDate();		
		Thread.sleep(2000);
		//Select arrival date and month
		flisearchobject.getReturnDate();
		Thread.sleep(3000);
		//select passengers
		flisearchobject.getPassengers();
		Thread.sleep(3000);
		//adult passengers
		flisearchobject.getAdultPassengers();
		Thread.sleep(2000);
		//child passengers
		flisearchobject.getChildPassengers();
		Thread.sleep(2000);
		//infant passengers
		flisearchobject.getInfantPassengers();
		Thread.sleep(3000);
				
		//Select family and friends checkbox
		//hp.getFamilyAndFriends();
		flisearchobject.getCheckBoxes();
		Thread.sleep(3000);
		
		flisearchobject.getSpecialAssistance();
		Thread.sleep(2000);		
				
	}
	
	
	@Test
	public void flightBookingSearch()
	{
		//Click Search button
		flisearchobject.getSearch();
				
	}
		
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
