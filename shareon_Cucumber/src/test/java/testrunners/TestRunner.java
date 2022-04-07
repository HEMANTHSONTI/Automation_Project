package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="featurefiles/Features.feature",
		glue="stepdefinitions",
		dryRun=false,
		tags=("@tag1,@tag2,@tag3,@tag4,@tag5,@tag6,@tag7,@tag8"),
		plugin={"com.cucumber.listener.ExtentCucumberFormatter:reports/loginresult.html"})

public class TestRunner 
{
	

}
