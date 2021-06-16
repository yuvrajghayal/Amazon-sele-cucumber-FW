package PageObjects;

import org.apache.logging.log4j.LogManager;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class SingInPageobjects {
private static final Logger Logger = LogManager.getLogger(SingInPageobjects.class);

private WebDriver driver;
private By input_textBox_email = By.id("ap_email");

public SingInPageobjects(WebDriver driver)
{
	this.driver = driver;
}

public void ValidateEmailInputTextBoxIsDisplayed()
{
	if (driver.findElement(input_textBox_email).isDisplayed()) {
		Assert.assertTrue(true);
		Logger.info("Email Input Box is Displayed");
	}
	else
	{
		Logger.fatal("Email input Box Is Displayed");
		Assert.fail("Email text Box Does Not Appear For Login After click on Sing in Button");
		
	}
	
}
public void enterTextInEmailTextBox(String text)

{
	Logger.info("Text entered in InEmail id :" + text);
	driver.findElement(input_textBox_email).sendKeys(text);
}
}
