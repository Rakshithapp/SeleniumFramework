package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.Webdriver_utility;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//declaration
	@FindBy(linkText="Products")
	private WebElement ProductlinkText;

	@FindBy(linkText="More")
	private WebElement Morelink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campiagnslinkText;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationslinkText;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlinkText;

	public WebElement getProductlinkText() {
		return ProductlinkText;
	}

	public WebElement getMorelink() {
		return Morelink;
	}

	public WebElement getCampiagnslinkText() {
		
		return campiagnslinkText;
	}

	public WebElement getOrganizationslinkText() {
		return OrganizationslinkText;
	}

	public WebElement getSignoutimg() {
		return signoutimg;
	}

	public WebElement getSignoutlinkText() {
		return signoutlinkText;
	}
	
	//Bussines logic for Product
	
	public void clickProductlink()
	{
		ProductlinkText.click();
	}
	
	//Bussines logic for More
	
	public void morelink(WebDriver driver)
	{
		Webdriver_utility wlib= new Webdriver_utility();
		wlib.mouseOverOnElement(driver, Morelink);
		
	}
	
	//campiagn
	
	public void campiagnslinkText()
	{
		campiagnslinkText.click();
	}
	
	//organization
	
	public void OrganizationslinkText()
	{
		OrganizationslinkText.click();
	}
	
	//Sign Out
	
	public void signoutlink(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.moveToElement(signoutimg).perform();
		signoutlinkText.click();
	}

	
		
	}
	




