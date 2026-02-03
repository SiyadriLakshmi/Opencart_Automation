package Utilities; // Package name for utility classes

import java.awt.Desktop; // Used to open the extent report automatically in browser
import java.io.File; // Used to handle file path
import java.io.IOException; // Used to handle IO exceptions
import java.text.SimpleDateFormat; // Used to format date and time
import java.util.Date; // Used to get current date and time
import java.util.List; // Used to handle list of groups

import org.testng.ITestContext; // Provides context information about test execution
import org.testng.ITestListener; // TestNG listener interface
import org.testng.ITestResult; // Provides result of test execution
import org.testng.internal.TestResult; // Internal TestNG test result class (not used now)

import com.aventstack.extentreports.ExtentReports; // Main ExtentReport class
import com.aventstack.extentreports.ExtentTest; // Represents a single test in report
import com.aventstack.extentreports.Status; // Represents status (PASS/FAIL/SKIP)
import com.aventstack.extentreports.reporter.ExtentSparkReporter; // Generates HTML report
import com.aventstack.extentreports.reporter.configuration.Theme; // Used to set report theme

import TestBase.Baseclass; // Base class for screenshot method

public class ExtentReportManager implements ITestListener { 
	// This class listens to TestNG events (start, success, failure, skip, finish)

	public ExtentSparkReporter sparkReporter; 
	// Responsible for creating HTML report UI

	public ExtentReports extent; 
	// Main object to manage report data

	public ExtentTest test; 
	// Represents each test case in the report

	public String repName; 
	// Stores report file name

	public void onStart(ITestContext testContext) {
		// This method executes before the test suite starts

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		// Generates current timestamp to create unique report name

		repName ="Test-Report-" + timeStamp + ".html";
		// Creates unique report file name

		sparkReporter= new ExtentSparkReporter(".\\reports\\" + repName);
		// Specifies the location where report will be generated

		sparkReporter.config().setDocumentTitle("opencart Automation Report");
		// Sets the title of the report

		sparkReporter.config().setReportName("opencart Functional Testing");
		// Sets the name of the report

		sparkReporter.config().setTheme (Theme.DARK);
		// Sets report theme as DARK

		extent = new ExtentReports();
		// Creates ExtentReports object

		extent.attachReporter(sparkReporter);
		// Attaches spark reporter to extent report

		extent.setSystemInfo("Application", "opencart");
		// Adds application name in report

		extent.setSystemInfo("Module", "Admin");
		// Adds module name in report

		extent.setSystemInfo("Sub Module", "Customers");
		// Adds sub-module name in report

		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		// Adds system username in report

		extent.setSystemInfo("Environemnt", "QA");
		// Adds environment details in report

		String os=testContext.getCurrentXmlTest().getParameter("os");
		// Gets OS parameter from testng.xml

		extent.setSystemInfo("Operating System", os);
		// Adds OS information in report

		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		// Gets browser parameter from testng.xml

		extent.setSystemInfo("Browser", browser);
		// Adds browser information in report

		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		// Gets executed groups from testng.xml

		if(!includedGroups.isEmpty()) {
			// Checks if groups are present

			extent.setSystemInfo("Groups", includedGroups.toString());
			// Adds group names in report
		}
	}

	public void onTestSuccess (ITestResult result) {
		//test = extent.createTest(result.getTestClass().getName());
				//test = extent.createTest(result.getMethod().getMethodName());
		// This method executes when test case passes

		test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
		// Creates a test entry in report with ClassName + MethodName

		test.assignCategory(result.getMethod().getGroups());
		// Assigns TestNG groups to the test case in report

		test.log(Status.PASS,result.getName()+" got successfully executed");
		// Logs PASS status in report
	}

	public void onTestFailure (ITestResult result) {
		//test = extent.createTest(result.getTestClass().getName());
				//test = extent.createTest(result.getMethod().getMethodName());
		// This method executes when test case fails

		test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
		// Creates a test entry in report with ClassName + MethodName

		test.assignCategory(result.getMethod().getGroups());
		// Assigns groups to failed test case

		test.log(Status.FAIL, result.getName()+" got failed");
		// Logs FAIL status in report

		test.log(Status.INFO, result.getThrowable().getMessage());
		// Logs failure reason (exception message)

		try {
			String imgPath = new Baseclass().captureScreen(result.getName());
			// Captures screenshot when test fails

			test.addScreenCaptureFromPath(imgPath);
			// Attaches screenshot to report
		}
		catch (IOException e1) {
			e1.printStackTrace();
			// Prints exception if screenshot fails
		}
	}

	public void onTestSkipped (ITestResult result) {
		//test = extent.createTest(result.getTestClass().getName());
				//test = extent.createTest(result.getMethod().getMethodName());
		// This method executes when test case is skipped

		test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
		// Creates a test entry in report

		test.assignCategory(result.getMethod().getGroups());
		// Assigns groups to skipped test case

		test.log(Status.SKIP, result.getName()+" got skipped");
		// Logs SKIP status in report

		test.log(Status.INFO, result.getThrowable().getMessage());
		// Logs skip reason
	}

	public void onFinish (ITestContext testContext) {
		//test = extent.createTest(result.getTestClass().getName());
				//test = extent.createTest(result.getMethod().getMethodName());
		// This method executes after all tests finish

		extent.flush();
		// Writes all test information into HTML report file

		String pathofExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		// Gets full path of generated report

		File extentReport = new File(pathofExtentReport);
		// Creates file object for report

		try {
			Desktop.getDesktop().browse(extentReport.toURI());
			// Opens the report automatically in browser
		} 
		catch (IOException e) {
			e.printStackTrace();
			// Prints exception if report cannot be opened
		}
	}
}



