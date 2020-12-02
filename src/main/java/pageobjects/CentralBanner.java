package pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CentralBanner {
	
	public WebDriver driver;
	
	public CentralBanner(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By banner = By.cssSelector("div[class='slider-container hide-mobile']");
	
	public void getBanner() throws InterruptedException
	{
		try {
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
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
