package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.model.Log;

import lombok.extern.log4j.Log4j2;



@Log4j2
public class LoginPageObjects {

	WebDriver driver;
	
	By userName = By.id("ap_email");
	By userpassword = By.id("ap-credential-autofill-hint");
	By singInButton = By.xpath("//input[@value='Sign in']");
	
	public LoginPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void loginApp(String u,String p)
	{
		driver.findElement(userName).sendKeys(u);
		driver.findElement(userpassword).sendKeys(p);
		driver.findElement(singInButton).click();
	//	Log.info("");
	}
}
