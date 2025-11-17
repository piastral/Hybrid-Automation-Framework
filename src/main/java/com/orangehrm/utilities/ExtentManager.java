package com.orangehrm.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
/* Extent report implementation in the framework
 * Benefits of using Extent Report 
 * 1-> Extent report is popular reporting library in selenium 
 * it provides interactive and visually appeling reports for automation test cases :
 * Hoghlights 
 * Detailes testSteps And Logs 
 * Screenshot for test Validation  -->Base64 
 * We will make multithreaed for parallel execution 
 * 
 * User friendly ui --> easy to unsderstand for stakeholders 
 * customisable reports add to own branding thems and structure 
 * Screenshot intergation : Attach Screenshot for pass fails scenarios 
 * Support for MultiThreading : HELPS IN parallel testing 
 * Easy intergaration compatible with maven 
 * 
 * How extent reports works ::
 * Initilizr report ;configure theme ,name  etc 
 * start and end test : track individual test cases 
 * Logs :logs ,info pass,fail,skip with clear messages with extent report 
 * Screenshot : better
 * 
 * How to implement :
 * 1-depedencies.extentreport and commons-Io
 * 2-reate extent manager class - logic for extent report /take attach screenshot in BAser64 format 
 * 3- DEFINE methods t initiize report and manage test threads 
 * 4-change in baseclass,actionDriver and testClasses .
 * 
 * 
 * 
 * 	
 */
	
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	private static Map<Long,WebDriver> driverMap=new HashMap<>();
	
	//Initilize extent report 
	
	public static ExtentReports getReporter() {
		if(extentReports==null) {
			String reportPath = System.getProperty("user.dir")+"/src/test/resources/ExtentReport/ExtentReport.html";
			ExtentSparkReporter spark =new  ExtentSparkReporter(reportPath);
			spark.config().setReportName("Automation Test Reports");
			spark.config().setDocumentTitle("OrangeHrmReport");
			spark.config().setTheme(Theme.DARK);
			
			extentReports = new ExtentReports();
			//Adding system information 
			extentReports.setSystemInfo("Operation System", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
			extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
		}
		return extentReports;
	}
	// start the test 
	
	public static  ExtentTest startTest(String testName) {
	 ExtentTest test=	getReporter().createTest(testName);
	 extentTest.set(test);
	 return test;
	}
	
	//end test 
	
	public static  void endTest( ) {
	    getReporter().flush();
		
		}
	
	// Get current Threads testName 
	public static ExtentTest getTest() {
	return extentTest.get();
	}
	
	// Method to get the name of the current test 
	public static String getTestName() {
		ExtentTest currentTest =getTest();
		if(currentTest!=null) {
			return currentTest.getModel().getName();
			
		} else {
			return "No test is currently active for this thread";
		}
	}
	
	// log a step 
	
	public static void logStep(String logMessage) {
		
		 getTest().info(logMessage);
	}
		
	
	// log step validation with screenshot 
	public static void logStepWithScreenshot(WebDriver driver , String logMessage,String screensShotMessage) {
		
		 getTest().pass(logMessage);
		 // Screentshot method 
	}
	
	//log a failure 
	public static void logFailureWithScreenShot(WebDriver driver , String logMessage,String screensShotMessage) {
		getTest().fail(logMessage);
		//Screenshot method later 
	}
	// skip test 
	
	public static void logSkippedWithScreenshot(WebDriver driver , String logMessage,String screensShotMessage) {
		getTest().skip(logMessage);
		//Screenshot method later 
	}
	
	// Take screenshot with date and time 
	
	public static String takeScreenshot(WebDriver driver, String screenshotFileName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		//format date and time for file name 
	  String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	  
	  
	  // Saving the screenshot to a file 
	  String destinationPath =  System.getProperty("user.dir")+"src/test/resources/screenshots/Screenshot" +screenshotFileName+"_"+timeStamp+".png";
	File finalPath=	new File(destinationPath);
	FileUtils.copyFile(src, finalPath);
	
	//convert screenShot into Base64 for embedding in the report 
	String base64Format = "";
	return base64Format;
	}
	
		
	
	
	
	
	
	
	
	//Register Webdriver for current thread 
	
	public static void registerDriver(WebDriver driver) {
		driverMap.put(Thread.currentThread().getId(), driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
