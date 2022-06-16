package Utility;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Jordan Liu\\eclipse-workspace\\Phase2-Swiggy_App_In_Diff_Env\\Features\\SwiggyApplication.feature", glue = {
		"Runner" }, plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" })
public class CucumberRunner {	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(
				"C:\\Users\\Jordan Liu\\eclipse-workspace\\Phase2-Swiggy_App_In_Diff_Env\\src\\test\\resources\\extent-config.xml"));
	}
}
