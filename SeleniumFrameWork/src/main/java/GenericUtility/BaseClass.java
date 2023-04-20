package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;

import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	
	@BeforeSuite(groups= {"smoketest", "regressiontest"})
	public void BS()
	{
		System.out.println("Database Connection");
	}
	
	@BeforeTest(groups= {"smoketest", "regressiontest"})
	public  void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	@org.testng.annotations.Parameters("BROWSER")
	@BeforeClass(groups= {"smoketest", "regressiontest"})
	
	public void BC(String BROWSER) throws Throwable
	//public void BC() throws Throwable
	{
		//Property_Utility plib=new Property_Utility();
		//String browser = plib.getKeyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
				{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
				}	
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		System.out.println("Launching Browser");
	}
	@BeforeMethod(groups= {"smoketest", "regressiontest"})
	public void BM() throws Throwable
	{
		Property_Utility plib1 = new Property_Utility();
		String URL = plib1.getKeyValue("url");
		String USERNAME = plib1.getKeyValue("username");
		String PASSWORD = plib1.getKeyValue("password");
		driver.get(URL);	
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login Application");
	}
	@AfterMethod(groups= {"smoketest", "regressiontest"})
	public void AM()
	{
		HomePage home= new HomePage(driver);
		home.signoutlink(driver);
		System.out.println("Logout Application");
	}
	@AfterClass(groups= {"smoketest", "regressiontest"})
	public void AC()
	{
		System.out.println("Browser Closed");
	}
	@AfterTest(groups= {"smoketest", "regressiontest"})
	public void AT()
	{
		System.out.println("Parallel Excecution done");
	}
	@AfterSuite(groups= {"smoketest", "regressiontest"})
	public void AS()
	{
		System.out.println("Data Connection close");
	}
	
			
	}


