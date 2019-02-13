package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utilities.BrowseFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
		
	@BeforeSuite
	public void setUpSuite() throws IOException {
		Reporter.log("Setting up the report and test is getting ready",true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/Naukri+"+Helper.getCurrentDateTime()+".html"));
		report= new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting done Test can be started", true);
	}
	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start Browser and getting application ready",true);
		driver=BrowseFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		Reporter.log("Browser and apllication is up and running", true);
	}
	@AfterClass
	public void tearDown() {
		Reporter.log("Test is about to end",true);
		BrowseFactory.quitBrowser(driver);
		Reporter.log("Test Completed>>>>Reports Generated", true);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
	}
		else if(result.getStatus()==ITestResult.SUCCESS) {	
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
	}
		report.flush();
	}

}

