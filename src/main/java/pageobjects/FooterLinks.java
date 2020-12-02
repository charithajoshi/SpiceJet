package pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FooterLinks {

	WebDriver driver;
	
	public FooterLinks(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By footerHeadings = By.cssSelector("tr[id='footer-headings'] td");
	By footerHeadingLinks = By.cssSelector("tr[class='footer-subheadings'] a");
	
	
	public int getFooterLinks() throws InterruptedException
	{
		
		int footerSize = driver.findElements(footerHeadings).size();
		System.out.println(footerSize);
		
		int footerLinksSize = driver.findElements(footerHeadingLinks).size();
		System.out.println(footerLinksSize);
		
		Actions act = new Actions(driver);
		Set<String> win_ids = driver.getWindowHandles();
		Iterator<String> it=win_ids.iterator();
		for(int i =0; i<footerLinksSize; i++)
		{
			String completeFooterLinkNames = driver.findElements(footerHeadingLinks).get(i).getText();
			System.out.println(completeFooterLinkNames);
			if((completeFooterLinkNames.contains("20")) | (completeFooterLinkNames.equalsIgnoreCase("RFP")) | completeFooterLinkNames.equalsIgnoreCase("Fitness To Fly Guideline") | completeFooterLinkNames.equalsIgnoreCase("Tariffs") | completeFooterLinkNames.equalsIgnoreCase("Know your rights") | completeFooterLinkNames.equalsIgnoreCase("Covid related information") | completeFooterLinkNames.equalsIgnoreCase("Track Your Bag"))
			{
				WebElement linksWith2020 = driver.findElements(footerHeadingLinks).get(i);
				
				act.moveToElement(linksWith2020).sendKeys(Keys.CONTROL).click().build().perform();
			}
			else {
				driver.findElements(footerHeadingLinks).get(i).click();
				Thread.sleep(2000);
				driver.navigate().back();
				Thread.sleep(3000);
			}
		}
		//driver.quit();
			
			while(it.hasNext())
			{
			String id = it.next();
			System.out.println(id);
							
			//driver.switchTo().window(id).close();
			}
			//driver.quit();
			
				
		return footerLinksSize;
		
	}
	
}
