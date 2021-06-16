package PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.junit.Assert;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class SearchPageObjects {
	private static final Logger Logger = LogManager.getLogger(SearchPageObjects.class);
	
	private WebDriver driver;

	
	private By search_refinment_categories_segment = By.id("s-refinements");
	private By product_link_list =By.xpath("//a[@class='a-link-normal a-text-normal']");
	private By txtbx_minimum_price_filter = By.name("low-price");
    private By txtbx_maximum_price_filter = By.name("high-price");
    private By go_button_price_filter = By.xpath("//input[@aria-labelledby='a-autoid-1-announce']");
    private By product_price_list = By.xpath(("//span[@class='a-price-whole']"));
    
    public SearchPageObjects(WebDriver driver)
    {
    	this.driver = driver;
    	
    }
    public void ValidateProductSearchIsSuccessfull()
    {
    	if(driver.findElement(search_refinment_categories_segment).isDisplayed())
    	{
    		Assert.assertTrue(true);
    		Logger.info("Search page Is Displayed Because refinement catagory is Displayed");
    		
    			
    	}
    	else
    	{
    		Logger.fatal("Search page Is  not Displayed Because refinement catagory is not Displayed");
    		Assert.fail("Search page Is  not Displayed Because refinement catagory is not Displayed");
    		 
    	}
    }
public  String ClickOnTheProductLink(int productIndex)  
{
    		
    		 List<WebElement> listOfProducts = driver.findElements(product_link_list);
    		 Logger.info("Number of Products Searched:" + listOfProducts.size());
    		 Logger.info("Clicked on the Link in the List with index: " + productIndex +
    	                ". Link Text: " + listOfProducts.get(productIndex).getText());
    		 return listOfProducts.get(productIndex).getText();
    	}
  
public void FilterSearchResultByPrice(String min,String max)
{
	driver.findElement(txtbx_minimum_price_filter).sendKeys(min);
	Logger.info("min price field set:" + min );
	
	driver.findElement(txtbx_maximum_price_filter).sendKeys(max);
	Logger.info("Max Price Field Set:" + max);
	
	driver.findElement(go_button_price_filter).click();
	Logger.info("Search Price Filter - Go Button clicked");
}
    public void VerifyThatSearchProductsAreInPriceRange(int min , int max)
    {
    	List<WebElement> product_price = driver.findElements(product_price_list);
    	
    	Logger.info("Get All the product price:");
    	boolean bResult = false;
    	int price_temp = 0;
    	for(int i=0;i<product_price.size();i++)
    	{
    	price_temp = Integer.parseInt(product_price.get(i).getText().replace(",",""));
        if(price_temp>=min && price_temp<=max)
        {
        	bResult = true;
        	Logger.info("for index:" + i + "product Price:" + price_temp + "and for Product:" + product_price.get(i).getText());
        	
        }
        else
        {
        	bResult = false;
        	Logger.error("product list is not with in price range. failed");
        	break;
        }
    }
    	if(bResult)
    	{
    		Assert.assertTrue("Search Result is with in the Define Range that is min :" + min + max,true);
    		Logger.info("All product is fillterd with right price range.min:" + min + "max" + max);
    		
    	}
    	else
    	{
    		Logger.error("All product is not filtered with right price range. Min: " + min + " Max: " + max);
            Assert.fail("Search Result is not with in the defined range i.e. Min: " + min + " Max: " + max );
    	}
    }
}
