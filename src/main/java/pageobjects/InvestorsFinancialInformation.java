package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvestorsFinancialInformation {

	WebDriver driver;
	
	public InvestorsFinancialInformation(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By annualReportsTable = By.cssSelector("div[class='acc_container2'] table[id='financialInfoTable']");
	By footerHeadingLinks = By.cssSelector("tr[class='footer-subheadings'] a");
	//By yearCols = By.xpath("//table[1]/tbody[1]/tr/td[1]");
	//By reportCols = By.xpath("//table[1]/tbody[1]/tr/td[2]");
	
	//By yearRow = By.xpath("//tbody[1]/tr[2]"); //Entire row
	//By annualReportRow = By.xpath("//tbody[1]/tr[2]/td[2]");
	
	
	//By rows = By.cssSelector("div[class='acc_container2'] table[id='financialInfoTable'] tr");  //12 Elements
	//By annualReportCol = By.cssSelector("div[class='acc_container2'] table[id='financialInfoTable'] a"); //12 elements of second column
	
	public void stringArrays()
	{
		List<String> stringArrayList2 = new ArrayList<String>();

		List<String> stringArrayList = new ArrayList<String>();
		stringArrayList.add("abc1");
		stringArrayList.add("abc2");
		stringArrayList.add("abc3");
		stringArrayList.add("abc4");
		stringArrayList.add("abc5");
		stringArrayList.add("abc6");
		
		for(int i = 0 ; i<stringArrayList.size();i++) {
			String string = stringArrayList.get(i);
			System.out.println("STYLE 1 : i : element = "+i+" : "+ string);
		}

		for(String element : stringArrayList2) {
			System.out.println("STYLE 2 : element = "+element);
		}
	}
	
	public void clickFinancialInformation()
	{
		int footerLinks = driver.findElements(footerHeadingLinks).size();
		System.out.println(footerLinks);
		
		for(int i =0; i<footerLinks; i++)
		{
			String linkText = driver.findElements(footerHeadingLinks).get(i).getText();
			if(linkText.equalsIgnoreCase("Financial Information"))
			{
				driver.findElements(footerHeadingLinks).get(i).click();
			}
		}
		
	}
	
	public WebElement getAnnualReports() throws InterruptedException
	{
		
	
//		WebElement table =driver.findElement(annualReportsTable);
//		
//		List<WebElement> allRowsOfTheTable = table.findElements(By.tagName("tr"));
//	    //Print data from each row
//
//	    for (int i = 0; i<allRowsOfTheTable.size(); ++i) {
//	    	WebElement eachRow = allRowsOfTheTable.get(i);
//	    	
//	        List<WebElement> allColumnsForTheGivenRow = eachRow.findElements(By.tagName("td"));
//	        for (int j = 0; j<allColumnsForTheGivenRow.size(); ++j) {
//	        	
//	        	WebElement eachColumnOfTheGivenRow  = allColumnsForTheGivenRow.get(j);
//	            System.out.print(eachColumnOfTheGivenRow.getText() + "\t");
//	            if(eachColumnOfTheGivenRow.getText().equalsIgnoreCase("Annual Report"))
//	            {
//	            	eachColumnOfTheGivenRow.click();
//	            }
//	          
//	        }
//	        System.out.println();
//	    }		    

	    WebElement table =driver.findElement(annualReportsTable);
	    List<WebElement> allRowsOfTheTable = table.findElements(By.tagName("tr"));
	    for (WebElement eachRow : allRowsOfTheTable) {
	        List<WebElement> allColumnsForTheGivenRow = eachRow.findElements(By.tagName("td"));
	        for (WebElement eachColumnOfTheGivenRow : allColumnsForTheGivenRow) {
	            System.out.print(eachColumnOfTheGivenRow.getText() + "\t");
	            if(eachColumnOfTheGivenRow.getText().equalsIgnoreCase("Annual Report"))
	            {
	            	eachColumnOfTheGivenRow.click();
					Thread.sleep(1000);
	            }
	          
	        }
	        System.out.println();
	    }		
		return table;
	}
	
}

	
