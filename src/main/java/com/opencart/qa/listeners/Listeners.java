package com.opencart.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.opencart.qa.utility.ExtentReporter;
import com.opencart.qa.utility.utilities;

public class Listeners implements ITestListener {
	
	ExtentReports extentreport;
	ExtentTest extenttest;

	@Override
	public void onStart(ITestContext context) {
	
		 extentreport=ExtentReporter.generatereport();
		
		System.out.println("project execution started");
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String testname=result.getName();
	    extenttest = extentreport.createTest(testname);
		extenttest.log(Status.INFO, testname+"...."+"project started  executing ...........");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testname=result.getName();
		extenttest = extentreport.createTest(testname);
		extenttest.log(Status.PASS,testname+"...."+"project executed successfully" );
	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testname=result.getName();
		
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		
			e.printStackTrace();
		}
		String DestinationScreenshotpath=utilities.captureScrenshot(driver, testname);
		
		extenttest.addScreenCaptureFromPath(DestinationScreenshotpath);
		
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL, testname+"...."+"project execution failed ");

		System.out.println("Screenhot Taken");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testname=result.getName();
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.SKIP,testname+"...."+"project was skipped ");
		
	
	}

	

	@Override
	public void onFinish(ITestContext context) {
		
		extentreport.flush();
		
		File reportpath= new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreports.html");
		try {
			Desktop.getDesktop().browse(reportpath.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
