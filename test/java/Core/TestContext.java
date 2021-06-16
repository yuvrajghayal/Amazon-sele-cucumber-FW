package Core;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;

import PageObjects.*;


public class TestContext {
	public WebDriver driver;
	public String base_url = "https://amazon.in";
	public int implicit_Wait_time_out_in_sec=20;
	public Scenario scn;
	
	
	public ComnPageObjects comnPageObjects;
	public HomePageObjects homePageObjects;
	public LoginPageObjects loginPageObjects;
	public ProductDescriptionPageObjects ProductDescriptionpageObjects;
	public SearchPageObjects searchPageObjects;
	public SingInPageobjects SingInpageObjects;

}
