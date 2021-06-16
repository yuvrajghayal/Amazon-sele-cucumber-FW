package Core;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



//@Log4j2

public class WebDriverFactory 
{
private static final Logger Logger = LogManager.getLogger(WebDriverFactory.class);
private static WebDriver driver=null;
public static WebDriver getWebDriverForBrowser(String browser)throws Exception{
	switch(browser.toLowerCase()) {
	case "chrome":
		driver = new ChromeDriver();
		((Logger) Logger).info("Chrome Browser invoked");
		break;
	case "firefox":
		driver= new FirefoxDriver();
		((Logger) Logger).info("FireFox Browser invoked");
		break;
	case "headless":
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200*600");
		driver = new ChromeDriver(options);
		Logger.info("Headless Chrome Browser invoked");
		break;
		default:
			Logger.fatal("No Such Browser Implemented. Browser Name sent:" + browser);
			throw new Exception("No Such Browser Implemented. Browser Name sent:" + browser);
			
		
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Logger.info("Driver Maximazed and implicit time out set to 20 seconds");
	return driver;
}
public static void navigateToUrl(String url)
{
	driver.get(url);
	Logger.info("Browser navigate to Url" + url);
}
public static void SwitchBrowserToTab()
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	Set<String> handles= driver.getWindowHandles();
	Logger.info("List of window found:" + handles.size());
	Logger.info("Windows Handles:" + handles.toString());
	Iterator<String> it= handles.iterator();
	String original = it.next();
	String nextTab =it.next();
	driver.switchTo().window(nextTab);
	Logger.info("Switch to the new window");
	
	
}
public static void SwitchToOriginalTab() {
	Set<String> handles = driver.getWindowHandles();
	Logger.info("List of window found:" + handles.size());
	Logger.info("windows Handles:" + handles.toString());
	Iterator<String> it= handles.iterator();
	String original = it.next();
	driver.switchTo().window(original);
	Logger.info("Switch to the new window");
	
}
public static String getBrowserName() {
	String browserDefault = "chrome";
	String browserSentFromCmd = System.getProperty("browser");
	
	if (browserSentFromCmd==null) {
		return browserDefault;
		
	}else
	{
		return browserSentFromCmd;
	}
			
}
public static void quitDriver() {
	 driver.quit();
     Logger.info("Driver closed");
}

}
