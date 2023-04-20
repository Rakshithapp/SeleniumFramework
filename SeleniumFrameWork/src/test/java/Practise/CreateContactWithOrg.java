package Practise;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.Excel_utility;
import GenericUtility.Java_Utility;
import GenericUtility.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrg {

	public static void main(String[] args) throws Throwable {
		
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();*/
		
		Property_Utility plib=new Property_Utility();
		String browser = plib.getKeyValue("browser");
		
		WebDriver driver =null;
		if(browser.equalsIgnoreCase("chrome"))
				{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
				}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Property_Utility plib1= new Property_Utility();
		String URL = plib1.getKeyValue("url");
		String USERNAME = plib1.getKeyValue("username");
		String PASSWORD = plib1.getKeyValue("password");
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		Java_Utility jlib= new Java_Utility();
		int RanNum = jlib.getRandomNum();
		  
		Excel_utility elib= new Excel_utility();
		String Exceldata= elib.getExcelData("Organization", 0, 0)+RanNum;
		
	    
		Thread.sleep(10);
		driver.findElement(By.name("accountname")).sendKeys(Exceldata);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		driver.findElement(By.linkText("Contacts")).click();
		
		

		
	         
	}

}
