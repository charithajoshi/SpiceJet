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

public class HomePage {
	
	public WebDriver driver;
	public String outDateSelected = "24";
	public String inDateSelected = "5";
	
	
	public HomePage(WebDriver driver) //Constructor
	{
		this.driver = driver;
	}
	
	By departureCity = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	By departCity = By.cssSelector("a[value='BLR']");
	By destinationCity = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	By arrivalCity = By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='JAI']");
	By departDate1 = By.id("ctl00_mainContent_view_date1");
	By departMonth = By.cssSelector("div[class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left'] [class='ui-datepicker-title']");
	By next = By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']");
	By departDate = By.cssSelector("td[data-handler='selectDay']");
	By returnDate = By.id("ctl00_mainContent_view_date2");	
	By passengers = By.id("divpaxinfo");
	By adultPassengers = By.id("ctl00_mainContent_ddl_Adult");
	By childPassengers = By.id("ctl00_mainContent_ddl_Child");
	By infantPassengers = By.id("ctl00_mainContent_ddl_Infant");	
	By search = By.id("ctl00_mainContent_btn_FindFlights");
	By oneWay = By.xpath("//input[@id= 'ctl00_mainContent_rbtnl_Trip_0']");
	By roundTrip = By.xpath("//input[@id= 'ctl00_mainContent_rbtnl_Trip_1']");
	By multiCity = By.xpath("//input[@id= 'ctl00_mainContent_rbtnl_Trip_2']");
	By familyAndFriends = By.cssSelector("div[id='familyandfriend']");
	By seniorCitizen = By.cssSelector("div[id='ctl00_mainContent_SeniorCitizenDiv']");
	By armedMilForces = By.cssSelector("div[id='ctl00_mainContent_studentAndDefense']");
	By student = By.cssSelector("div[id='StudentDiv']");
	By unaccompaniedMinor = By.cssSelector("div[id='UnmrDiv']");
	By specialAssistance = By.linkText("Special Assistance");
	By chkbox = By.cssSelector("div[id='discount-checkbox'] input");
	By closeSpecialAssistance = By.cssSelector("a[id='SpecialAssistanceWindow']");
	By banner = By.cssSelector("div[class='slider-container hide-mobile']");
	
	By border = By.cssSelector("div[class='middle-cont color-f0efef hide-xs hide-sm'] div[class*='middle'] div[class='middle-block-cont']");
	
	//Login/SIGNUP
	By logSinup = By.xpath("//a[@id='ctl00_HyperLinkLogin']");
	By speMembers = By.xpath("//a[@id='ctl00_HyperLinkLogin']/following-sibling::ul/li[2]");
	By memLog = By.xpath("//a[@id='ctl00_HyperLinkLogin']/following-sibling::ul/li/ul/li[1]");
	
	
	public WebElement getDeparture()
	{
		WebElement dep = driver.findElement(departureCity);
		dep.click();
		return dep;
	}
	
	public WebElement getDepartCity() 
	{
		WebElement dCity = driver.findElement(departCity);
		dCity.click();
		return dCity;
	}
	
	public WebElement getDestination()
	{
		return driver.findElement(destinationCity);
	}
	
	public WebElement getArrivalCity() 
	{
		WebElement acity = driver.findElement(arrivalCity);
		acity.click();
		return acity;
	}
	
	public WebElement getDepartureDate()
	{
		WebElement outgoingMonth = driver.findElement(departMonth);
		
		while(!outgoingMonth.getText().contains("May"))
		{
			driver.findElement(next).click();
			outgoingMonth = driver.findElement(departMonth);
		}
		
		int dates = driver.findElements(departDate).size();
		
		for(int i=0; i<dates; i++)
		{
			String outDate=driver.findElements(departDate).get(i).getText();
			if(outDate.equalsIgnoreCase(outDateSelected))
			{
				driver.findElements(departDate).get(i).click();
				break;
			}
		}
		return outgoingMonth;		
		
	}
	
	public WebElement getReturnDate()
	{
		driver.findElement(returnDate).click();
		WebElement incomingMonth = driver.findElement(departMonth);
		
		while(!incomingMonth.getText().contains("June"))
		{
			driver.findElement(next).click();
			incomingMonth = driver.findElement(departMonth);
		}
		
		int dates = driver.findElements(departDate).size();
		for(int i=0; i<dates; i++)
		{
			String inDate = driver.findElements(departDate).get(i).getText();
			if(inDate.equalsIgnoreCase(inDateSelected))
			{
				driver.findElements(departDate).get(i).click();
				break;
			}
		}
		return incomingMonth;
	}
	
	public WebElement getPassengers()
	{
		WebElement pass = driver.findElement(passengers);
		pass.click();
		return pass;
	}
	
	public void getAdultPassengers()
	{
		Select s = new Select(driver.findElement(adultPassengers));
		s.selectByVisibleText("4");
	}
	
	public void getChildPassengers()
	{
		Select c = new Select(driver.findElement(childPassengers));
		c.selectByValue("1");		
		
	}
	
	public void getInfantPassengers() 
	{
		Select i = new Select(driver.findElement(infantPassengers));
		i.selectByIndex(2);
	}
	
	public void getSearch()
	{
		driver.findElement(search).click();
	}
	
	public WebElement getOneWay()
	{
		return driver.findElement(oneWay);
	}
	
	public WebElement getRoundTrip()
	{
		WebElement round = driver.findElement(roundTrip);
		round.click();
		return round;
	}
	
	public WebElement getMultiCity()
	{
		return driver.findElement(multiCity);
	}
	
	public void getFamilyAndFriends()
	{
		driver.findElement(familyAndFriends).click();
	}
	
	public void getSeniorCitizen()
	{
		driver.findElement(seniorCitizen).click();
	}
	
	public WebElement getArmedMilitaryForces()
	{
		return driver.findElement(armedMilForces);
	}
	
	public WebElement getStudent()
	{
		return driver.findElement(student);
	}
	
	public WebElement getUnaccompaniedMinor()
	{
		return driver.findElement(unaccompaniedMinor);
	}
	
	public void getCheckBoxes() throws InterruptedException
	{
		int noOfCheckboxes = driver.findElements(chkbox).size();
		for(int i=0; i<noOfCheckboxes; i++)
		{
			driver.findElements(chkbox).get(i).click();
			Thread.sleep(1000);
			
		}
	}
	
	public void getSpecialAssistance()
	{
		driver.findElement(specialAssistance).click();
		driver.findElement(closeSpecialAssistance).click();
		
	}
	
	public void getBanner() throws InterruptedException
	{
		WebElement ban = driver.findElement(banner);
		
		System.out.println(driver.getTitle());
		Actions act = new Actions(driver);
		act.moveToElement(ban).contextClick().sendKeys(Keys.ARROW_DOWN).click().build().perform();
		Thread.sleep(3000);
		
		Set<String> win_ids = driver.getWindowHandles();
		Iterator<String> it=win_ids.iterator();
		String parent_id = it.next();
		String child_id = it.next();
		
		//driver.switchTo().window(parent_id);
				
		driver.switchTo().window(child_id);
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parent_id);
		System.out.println(driver.getTitle());
		
	}
	
	public WebElement getBorder() throws InterruptedException
	{
		WebElement bor = driver.findElement(border);
		WebElement closePopup = driver.findElement(By.cssSelector("a[class='popup-close2 close-icon-style2']"));
		int numbers = driver.findElements(border).size();
		System.out.println(numbers);
		Actions act = new Actions(driver);	
		
		Set<String> win_ids = driver.getWindowHandles();
		Iterator<String> it=win_ids.iterator();
		
		for(int i =0; i<numbers; i++)
		{
			WebElement borderItems = driver.findElements(border).get(i);
					
			System.out.println(borderItems.getText());
			if(borderItems.getText().equalsIgnoreCase("Corporate Traveller")) {
				act.moveToElement(borderItems).sendKeys(Keys.CONTROL).click().build().perform();
			}
			
			Thread.sleep(3000);
			if(closePopup.isDisplayed())
			{
				//driver.switchTo().window(id);
				closePopup.click();
				Thread.sleep(3000);
			}
			//Thread.sleep(3000);
		}
		
		while(it.hasNext())
		{
			String id = it.next();
			System.out.println(driver.getTitle());
			driver.switchTo().window(id);
			//driver.close();
		}
		driver.quit();
				
		return null;
		
	}
	
	//LOGIN/SIGNUP;
	
	public WebElement getLoginSignup() throws InterruptedException
	{
		WebElement hover = driver.findElement(logSinup);
		Actions log = new Actions(driver);
		log.moveToElement(hover).build().perform();
		
		WebElement specialMembers = driver.findElement(speMembers);
		log.moveToElement(specialMembers).build().perform();
		Thread.sleep(3000);
		
		WebElement memberLogin = driver.findElement(memLog);
		log.moveToElement(memberLogin).click().build().perform();
		return memberLogin;
	}
}
