package Campaign;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.Excel_utility;
import GenericUtility.Java_Utility;
import POM.CampaignCreationPage;
import POM.HomePage;
import POM.ValidationAndVerificationPage;

public class CreateCampiagn extends BaseClass {

	@Test(groups="smoketest")
	public void createCampiagn() throws Throwable {
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
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		
		//LoginPage LoginPage = new LoginPage(driver);
		//LoginPage.loginToApp(USERNAME, PASSWORD);
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		HomePage home=new HomePage(driver);
		home.morelink(driver);
		home.campiagnslinkText();
		
		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.linkText("Campaigns")).click();
		

		CampaignCreationPage cam=new CampaignCreationPage(driver);
		cam.campaigncreateimage();
		
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		

	     Java_Utility jlib= new Java_Utility();
	     int RanNum = jlib.getRandomNum();
		
	    // Random ran=new Random();
			//int RamNum = ran.nextInt(1000);
			
	     
	     Excel_utility elib= new Excel_utility();
			String campdata= elib.getExcelData("Campiagn", 0, 0)+RanNum;
			
		/*FileInputStream fes= new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Campiagn");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String campdata = cell.getStringCellValue()+RanNum;*/
		
		cam.campaignnametext(campdata);
		
		//driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campdata);
		
		cam.savebutton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
        validate.organisationValidation(driver, campdata);
        
		/*String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		
		if(actData.contains(campdata))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}*/
		
		Thread.sleep(10);
		
		//home.signoutlink(driver);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		

	}

}
