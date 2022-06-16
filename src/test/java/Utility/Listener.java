package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listener implements ITestListener {

	ExtentReports extent;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Starting of test : " + result.getName());
		System.out.println(" ----- ----- ----- ----- ----- ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test : " + result.getName() + " is passed!");
		test.log(LogStatus.PASS, result.getName() + " is passed!");
		System.out.println(" ----- ----- ----- ----- ----- ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test : " + result.getName() + " is failed!");
		test.log(LogStatus.FAIL, result.getName() + " is failed!");
		System.out.println(" ----- ----- ----- ----- ----- ");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test : " + result.getName() + " is skipped!");
		test.log(LogStatus.SKIP, result.getName() + " is skipped!");
		System.out.println(" ----- ----- ----- ----- ----- ");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Project : " + context.getName() + " is started!");
		extent = GenerateReport.createReport();
		test = extent.startTest(context.getName());
		System.out.println(" ----- ----- ----- ----- ----- ");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Project : " + context.getName() + " is ended!");
		extent.endTest(test);
		extent.flush();
		System.out.println(" ----- ----- ----- ----- ----- ");
	}

}
