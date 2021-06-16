package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.junit.Assert;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HomePageObjects {
	private static final Logger Logger = LogManager.getLogger(HomePageObjects.class);
	private WebDriver driver;
	
private String menu_item_text_element = "//button[@role='menuitem' and text()='%s']";

public HomePageObjects(WebDriver driver) {
	this.driver = driver;
	
}

public void ValidateMenuItemIsPresent(String MenuItemName)
{
	Logger.info("Validating the Menu item is Present .Menu Item Name :" + MenuItemName);
	Assert.assertEquals(driver.findElement(By.xpath(String.format(menu_item_text_element, MenuItemName))).isDisplayed(),true);
	
	
}
}
