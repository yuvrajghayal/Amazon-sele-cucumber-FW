package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
features="classpath:features",//to tell cucumber where is ur feature file
glue="StepDefs", // to tell cucumber where is ur step def code
tags="@healthcheck", // to tell which tagged feature file to execute
plugin = {"pretty", // to generate reports
        "html:target/html/htmlreport.html",
        "json:target/json/file.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},
publish=true,
dryRun=false
)
public class TestRunner {

	
	
}
