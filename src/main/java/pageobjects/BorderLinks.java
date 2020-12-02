package pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BorderLinks {
	
	WebDriver driver;
	
	public BorderLinks(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By border = By.cssSelector("div[class='middle-cont color-f0efef hide-xs hide-sm'] div[class*='middle'] div[class='middle-block-cont']");
	By closePopup = By.cssSelector("a[class='popup-close2 close-icon-style2']");
	
	public WebElement getBorder() throws InterruptedException
	{
		//try {
		WebElement bor = driver.findElement(border);
		WebElement closePP = driver.findElement(closePopup);
		int numbers = driver.findElements(border).size();
		System.out.println(numbers);
		Actions act = new Actions(driver);	
		
		Set<String> win_ids = driver.getWindowHandles();
		Iterator<String> it=win_ids.iterator();
		
		for(int i =0; i<numbers; i++)
		{
			WebElement borderItems = driver.findElements(border).get(i);
					
			System.out.println(borderItems.getText());
			//if(borderItems.getText().equalsIgnoreCase("Corporate Traveller")) {
				
			//}
			act.moveToElement(borderItems).sendKeys(Keys.CONTROL).click().build().perform();
			
			Thread.sleep(3000);
			if(closePP.isDisplayed())
			{
				//driver.switchTo().window(id);
				closePP.click();
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
		//driver.quit();
				
		//}
		//catch(Exception e)
		//{
		//	System.out.println(e);
		//}
		return null;
		
	}
}
