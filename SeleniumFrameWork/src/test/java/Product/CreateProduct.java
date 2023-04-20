package Product;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.BaseClass;
import GenericUtility.Java_Utility;
import GenericUtility.Property_Utility;
import GenericUtility.Webdriver_utility;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationCreationPage;
import POM.ProductCreationPage;
import POM.ValidationAndVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct extends BaseClass {

	
	public void createProduct() throws Throwable {

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
		
		Webdriver_utility wlib= new Webdriver_utility();
		wlib.implicitlywait(driver);
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
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
		
		
		//driver.get(URL);
		
		/*LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD);
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		HomePage home= new HomePage(driver);
		home.clickProductlink();
		//driver.findElement(By.linkText("Products")).click();
		
		ProductCreationPage pro=new ProductCreationPage(driver);
		pro.productcreationimage();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		  Java_Utility jlib= new Java_Utility();
		  int RanNum = jlib.getRandomNum();
		
		 // Random ran=new Random();
		//int RamNum = ran.nextInt(1000);
		
		/*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet Sheet = book.getSheet("Product");
		Row Row = Sheet.getRow(0);
		Cell cell = Row.getCell(0);
		String productdata = cell.getStringCellValue()+RanNum;*/
		
		
		 pro.productnametext(productdata);
		//driver.findElement(By.name("productname")).sendKeys(productdata);
		  
		 pro.savebutton(); 
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
        validate.organisationValidation(driver,productdata);
        
		/*String actdata = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		
		if(actdata.contains(productdata))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}*/

		
		//driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
        
       // home.signoutlink(driver);
		//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
