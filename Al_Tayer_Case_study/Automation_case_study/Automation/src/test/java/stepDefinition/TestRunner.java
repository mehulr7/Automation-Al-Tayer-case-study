package stepDefinition;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import actions.Common;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src\\test\\resources\\feature", glue = "stepDefinition", plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:Result/report.html" },

		tags = { "@ProductListing," + "@FacebookLogin," + "@Register," + "@AddBag" })

public class TestRunner extends AbstractTestNGCucumberTests {

	public static ExtentReports extentReports = null;
	public static ExtentTest extentTest = null;

	@BeforeClass

	public static void extent() throws IOException {

		extentReports = new ExtentReports(System.getProperty("user.dir") + "\\Logs\\Report.html");

	}
	
	@AfterMethod
	
	public static void exit() {
		
		Common.driver.quit();
		extentTest.log(LogStatus.INFO, "Browser exit.");
	}

	@AfterClass

	public static void flush() {

		extentReports.flush();

		// extentReports.close();

		//Common.driver.quit();

	}

}
