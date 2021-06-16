package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class ProductDescriptionPageObjects {

	private static final Logger Logger = LogManager.getLogger(ProductDescriptionPageObjects.class);
	
	private WebDriver driver;
	
	private By product_title = By.id("productTitle");
	private By ass_to_cart_button = By.id("add-to-cart-button");
	private By deop_down_select_quantity = By.xpath("//select[@id='quantity']");
	private By text_added_to_cart_message = By.xpath("//div[@class='a-box a-alert a-alert-success added-to-cart-message-box']//h4[text()='Added to Cart']");
	private By text_added_to_cart_message_other_version = By.xpath("//h1[@class='a-size-medium a-text-bold' and contains(text(),'Added to Cart')]");
	
	
	public ProductDescriptionPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnAddToCartButton()
	{
		driver.findElement(ass_to_cart_button).click();
		Logger.info("Add to cart button on product description Page is Clicked.");
		
	}
	
	public void selectQuantity(String quantity)
	{
		Select select = new Select(driver.findElement(deop_down_select_quantity));
		select.selectByValue(quantity);
		Logger.info("Quantity is selected as:" + quantity);
	}
	
	public void CheckAddedToCartMassageIsDisplayed()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(text_added_to_cart_message));
			Assert.assertEquals("Added to cart Message", true,element.isDisplayed());
		}catch(Exception e) {
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element=wait .until(ExpectedConditions.visibilityOfElementLocated(text_added_to_cart_message_other_version));
			Assert.assertEquals("added to cart message", true, element.isDisplayed());
			
		}
	}
	public void ValidateProductTitleIsCorrectlyDisplayed()
	{
		if(driver.findElement(product_title).isDisplayed())
		{
			Assert.assertTrue(true);
			Logger.info("Product Title is Displayed");
			
		}
		else
		{
			Logger.fatal("Product Title is Not Displyed");
			Assert.fail("Product tiltle is not Displyed");
			
		}
	}
	public void ValidateAddtoCareButtonIsDisplayed() {
		if(driver.findElement(product_title).isDisplayed()) {
			Assert.assertTrue(true);
			Logger.fatal("Add toCart Button is Displayed");
			
		}
		else
		{
			Logger.fatal("Add to Cart Button  Not is Displayed");
			Assert.fail("Add toCart Button is Not Displayed");
					
		}
	}
}
