package Utility;

import com.relevantcodes.extentreports.ExtentReports;

public class GenerateReport {
	public static ExtentReports extent;

	public static ExtentReports createReport() {
		extent = new ExtentReports(
				"C:\\Users\\Jordan Liu\\eclipse-workspace\\Phase2-Swiggy_App_In_Diff_Env\\Reports\\ExtentReportResults.html");
		return extent;
	}
}