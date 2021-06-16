package StepDefs;

import org.openqa.selenium.WebDriver;

import Core.TestContext;
import Core.WebDriverFactory;
import PageObjects.*;


import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs2 {

	
	 TestContext testContext;
	    public  WebDriver driver;
	    public String base_url;
	    public Scenario scn;
	    public ComnPageObjects cmnPageObjects;
	    public HomePageObjects homePageObjects;
	    public SingInPageobjects SingInpageObjects;
	    public SearchPageObjects searchPageObjects;
	    public ProductDescriptionPageObjects productDescriptionPageObjects;

	    //Dependency Injections
	    public StepDefs2(TestContext testContext){
	        this.testContext = testContext;
	        cmnPageObjects = testContext.comnPageObjects;
	        homePageObjects = testContext.homePageObjects;
	        SingInpageObjects = testContext.SingInpageObjects;
	        searchPageObjects = testContext.searchPageObjects;
	        productDescriptionPageObjects = testContext.ProductDescriptionpageObjects;
	        base_url = testContext.base_url;
	    }
	 @When("User click on any product")
	 public void User_click_on_any_product() {
		 searchPageObjects.ClickOnTheProductLink(0);
	 }
	 @Then("Product Description is displayed in new tab")
	 public void Product_Description_is_displayed_in_new_tab() 
	 {
		 WebDriverFactory.SwitchBrowserToTab();
		 scn.log("Switched To NEw Window");
	 }
	 @Then("User cart is updated with the products and quantity")
	 public void User_cart_is_updated_with_the_products_and_quantity()
	 {
		 throw new io.cucumber.java.PendingException();
	 }
	 @When("User enters minimum price as {string} and maximum price as {string} mentioned in below table")
	    public void user_enters_minimum_price_as_and_maximum_price_as_mentioned_in_below_table(String min, String max) {
	        searchPageObjects.FilterSearchResultByPrice(min,max);
	    }

	    @Then("Verify that Search results gets filtered with price range between {int} and {int}")
	    public void search_results_gets_filtered_with_price_range_between_and(int min, int max) {
	        searchPageObjects.VerifyThatSearchProductsAreInPriceRange(min,max);
	    }
	
	
}
