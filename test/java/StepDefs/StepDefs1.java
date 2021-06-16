package StepDefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.aventstack.extentreports.model.Log;

import Core.TestContext;
import Core.WebDriverFactory;
import PageObjects.ComnPageObjects;
import PageObjects.HomePageObjects;
import PageObjects.LoginPageObjects;
import PageObjects.ProductDescriptionPageObjects;
import PageObjects.SearchPageObjects;
import PageObjects.SingInPageobjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class StepDefs1 {

	TestContext textContext;
	public WebDriver driver;
	public String base_url;
	public Scenario scn;
	public ComnPageObjects comnPageObjects;
	public HomePageObjects HomepageObjects; 
	public LoginPageObjects loginPageObjects;
	public ProductDescriptionPageObjects ProductDescriptionpageObjects;
	public SearchPageObjects searchPageObjects;
	public SingInPageobjects SingInpageObjects;
	
	public StepDefs1(TestContext testContext)
	{
		 this.textContext = testContext;
		 comnPageObjects = testContext.comnPageObjects;
		 HomepageObjects = testContext.homePageObjects;
		 SingInpageObjects = testContext.SingInpageObjects;
		 searchPageObjects = testContext.searchPageObjects;
		 ProductDescriptionpageObjects= testContext.ProductDescriptionpageObjects;
	        base_url = testContext.base_url;
	}
	@Before
	public void setUp(Scenario scn)throws Exception
	{
		this.scn= scn;
		
		String browserName = WebDriverFactory.getBrowserName();
		
		driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		comnPageObjects = new ComnPageObjects(driver);
		HomepageObjects = new HomePageObjects(driver);
		loginPageObjects = new LoginPageObjects(driver); 
		ProductDescriptionpageObjects = new ProductDescriptionPageObjects(driver);
		searchPageObjects= new SearchPageObjects(driver);
		SingInpageObjects = new SingInPageobjects(driver);
	}
	
	@After(order=1)
	public void cleanUp()
	{
		WebDriverFactory.quitDriver();
		
	}
	@After(order=2)
    public void takeScreenShot(Scenario s) {
        if (s.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        }else{
           scn.log("Test case is passed, no screen shot captured");
        }
    }
	@Given("User navigated to the home application url")
	public void User_navigated_to_the_home_application_url()
	{
		WebDriverFactory.navigateToUrl(base_url);
		scn.log("Browser navigated to URL " + base_url);
		
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		comnPageObjects.validatePageTitlematch(expected);
	}
	@When("User Search for product {String}")
	public void User_Search_for_product(String productName)
	{
		comnPageObjects.SetSearchTextBox(productName);
		comnPageObjects.ClickOnSearchButton();
		scn.log("Product Searched" + productName);
		
	}
	@Then("Search Result page is displayed")
	public void Search_Result_page_is_displayed() {
		searchPageObjects.ValidateProductSearchIsSuccessfull();
		
	}
}
