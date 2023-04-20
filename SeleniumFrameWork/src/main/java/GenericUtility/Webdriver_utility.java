package GenericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webdriver_utility {
	/**
	 * This method is used 
	 * @param driver
	 */
	public void implicitlywait(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	}

	public void switchwindow(WebDriver driver, String PartialWindowTitle)
	
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> id = allId.iterator();
		
		while(id.hasNext())
		{
			 String wid = id.next();
	    	  driver.switchTo().window(wid);
	    	  String title = driver.getTitle();
	    	  
		
		if(title.contains(PartialWindowTitle))
		{
			break;
		}
	}
  }

	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		  Actions act= new Actions(driver);
		  act.moveToElement(element).perform();
		  
		
	}
}
