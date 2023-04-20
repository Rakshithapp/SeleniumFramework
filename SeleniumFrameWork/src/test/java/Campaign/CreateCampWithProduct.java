package Campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.Excel_utility;
import GenericUtility.Java_Utility;
import GenericUtility.Property_Utility;
import GenericUtility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampWithProduct extends BaseClass {

	@Test 
	public void creatCampWithProduct() throws Throwable {
	//public static void main(String[] args) throws Throwable {
		
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();*/
		
		/*Property_Utility plib=new Property_Utility();
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
		
		driver.manage().window().maximize();

		Webdriver_utility wlib= new Webdriver_utility();
		
		
		Property_Utility plib1 = new Property_Utility();
		String URL = plib1.getKeyValue("url");
		String USERNAME = plib1.getKeyValue("username");
		String PASSWORD = plib1.getKeyValue("password");
		
		/*FileInputStream fis= new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
		
		/*driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		  Java_Utility jlib= new Java_Utility();
		  int RanNum = jlib.getRandomNum();
		
		  //Random ran=new Random();
			//int RamNum = ran.nextInt(1000);
		  
		//Excel_utility elib= new Excel_utility();
		//String productdata= elib.getExcelData("Product", 0, 0)+RanNum;
			
		Excel_utility elib=new Excel_utility();
		String productdata = elib.getExcelDataformatter("Product", 0, 0)+RanNum;
		  
		/*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet Sheet = book.getSheet("Product");
		Row Row = Sheet.getRow(0);
		Cell cell = Row.getCell(0);
		String productdata = cell.getStringCellValue()+RanNum;*/
		
		
		driver.findElement(By.name("productname")).sendKeys(productdata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		
		Java_Utility jlib1= new Java_Utility();
		  int RanNum1 = jlib1.getRandomNum();
		

		//Random ram1=new Random();
		//int ramNum1 = ram1.nextInt(1000);
		
		 //Excel_utility elib1= new Excel_utility();
		//String campdata= elib1.getExcelData("Campiagn", 0, 0)+RanNum1;
			
		 Excel_utility elib1=new Excel_utility();
		String campdata = elib1.getExcelDataformatter("Campiagn", 0, 0)+RanNum1;
			
		/*FileInputStream fes1= new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book1 = WorkbookFactory.create(fes1);
		Sheet sheet = book1.getSheet("Campiagn");
		Row row = sheet.getRow(0);
		Cell cell1 = row.getCell(0);
		String campdata = cell1.getStringCellValue()+ramNum1;*/
		
		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campdata);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		wlib.switchwindow(driver, "Products&action");
		
		/*Set<String> allId = driver.getWindowHandles();
		Iterator<String> id = allId.iterator();
		
		while(id.hasNext())
		{
			 String wid = id.next();
	    	  driver.switchTo().window(wid);
	    	  String title = driver.getTitle();
	    	  
		
		if(title.contains("Products&action"))
		{
			break;
		}
		
		}*/
		driver.findElement(By.id("search_txt")).sendKeys(productdata);
		driver.findElement(By.name("search")).click();
		
		//dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
		
		wlib.switchwindow(driver,"Campaigns&action");
		
		 /*Set<String> allId1 = driver.getWindowHandles();
         Iterator<String> id1 = allId1.iterator();
         
         while(id1.hasNext())
         {
       	  String wid1 = id1.next();
       	  driver.switchTo().window(wid1);
       	  String title = driver.getTitle();
       	  
       	  if(title.contains("Campaigns&action"))
       	  {
       		  break;
       	  }

         }*/

         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
         
        String act = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
        
         if(act.contains(campdata))
         {
         	System.out.println("camp pass");
         }
         else
         {
         	System.out.println("camp fail");
         }
         
        String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
         if(actData.contains(productdata))
         {
         	System.out.println("product Pass");
         }
         else
         {
         	System.out.println("Product fail");
         }
         
         driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
         driver.findElement(By.linkText("Sign Out")).click();
         
	}
}
