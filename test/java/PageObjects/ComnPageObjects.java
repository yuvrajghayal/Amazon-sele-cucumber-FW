package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import junit.framework.Assert;
@Log4j2
public class ComnPageObjects {
	private static final Logger Logger = LogManager.getLogger(ComnPageObjects.class);
	WebDriver driver;
	
	private By search_text_box = By.id("twotabsearchtextbox");
	private By search_button = By.xpath("//input[@value='Go']");
	private By humburger_menu_link = By.id("nav-hamburger-menu");
	private By nav_link_logo = By.xpath("//a[@class='nav-logo-link']");
	private By nav_link_cart = By.id("nav-cart");
	private By nav_link_prime =  By.id("nav-link-prime");
	private By nav_link_orders = By.id("nav-orders");
	private By nav_link_account = By.id("nav-link-accountList");
	
	private String hamburger_menu_category_link_xpath =  "//div[@id='hmenu-content']//div[text()='%s']";
	private String hamburger_menu_sub_category_link_xpath =  "//div[@id='hmenu-content']//a[text()='%s']";

	public ComnPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public void SetSearchTextBox(String text) {
		WebDriverWait webDriverWait = new WebDriverWait(driver,20);
		WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(search_text_box));
		elementSearchBox.clear();
		elementSearchBox.sendKeys(text);
		Logger.info("value Entered in Search Box:" + text);
		
	}
	public void ClickOnSearchButton()
	{
		driver.findElement(search_button).click();
		Logger.info("Clicked On Search Button");
		
	}
	public void ClickOnHamburgerMenuButton()
	{
		driver.findElement(humburger_menu_link).click();
		Logger.info("Clicked on hamburger_menu_button");
		
	}
	public void ClickedOnHamburgerMenuProductCategoryLink(String linkText)
	{
	By byElement = By.xpath(String.format(hamburger_menu_category_link_xpath,linkText));
	driver.findElement(byElement);
	Logger.info("Clicked On Hambarger Menu Category link:" + linkText);
	
	}
	public void ClickOnHamburgerMenuProductSubCategoryLink(String linkText)
	{
		By ByElement = By.xpath(String.format(hamburger_menu_sub_category_link_xpath, linkText));
		driver.findElement(ByElement).click();
		Logger.info("Clicked on Hamburger menu Sub Catagory Link:" + linkText);
		
	}
	public void validateHamBurgerMenuIsDisplayed() {
		boolean b = driver.findElement(humburger_menu_link).isDisplayed();
		Assert.assertEquals("Hamburger menu link",true, b);
		
	}
	public void validateAmazonLogo()
	{
		boolean b = driver.findElement(nav_link_logo).isDisplayed();
		Assert.assertEquals("Navigation link logo",true, b);
	}
	
	public void validatePageTitlematch(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("title Validation",true, b);
		Logger.info("Page Title Matched:" + expectedTitle);
	}
	public void validateElementPresentInHeaderSection(String text)throws Exception
	{
		boolean b = false;
		switch(text.toLowerCase().trim())
		{
		case "hamburger menu":
			b = driver.findElement(humburger_menu_link).isDisplayed();
			break;
		case "amazon prime logo":
			b=driver.findElement(nav_link_logo).isDisplayed();
			break;
		case "account and list link":
			b=driver.findElement(nav_link_account).isDisplayed();
			break;
		case "returns and orders":
			b=driver.findElement(nav_link_orders).isDisplayed();
			break;
		case "your prime link":
			b=driver.findElement(nav_link_prime).isDisplayed();
			break;
		case "cart link":
			b= driver.findElement(nav_link_cart).isDisplayed();
			break;
		case "search text box":
			b=driver.findElement(search_text_box).isDisplayed();
			break;
		default:
			Logger.fatal("header link Descrription Is not present in the case.please add link description first.");
			throw new Exception("header link Descrription Is not present in the case.please add link description first.");
			
			
		}
		if (b)
		{
			Logger.info("Header Link is displayed: " + text);
			Assert.assertEquals("Header Link displayed",true, b);
		}else {
			Logger.fatal("Header link is not Displayed:" + text);
			Assert.fail("Header link is not Displayed:" + text);
		}
	}
	
} 
