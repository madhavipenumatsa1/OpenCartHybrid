package com.Opencart.qa.listners;

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

import com.Opencart.qa.utils.ExtentReporter;
import com.Opencart.qa.utils.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListners implements ITestListener{
	WebDriver driver;
	ExtentReports extentReport;
	ExtentTest extentTest;
	@Override
	public void onStart(ITestContext context) {
		 extentReport	= ExtentReporter.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		 extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName+"Started Successfully");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest= extentReport.createTest(testName);
		extentTest.log(Status.PASS, testName+"Succesfully excuted");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName= result.getName();
		 WebDriver driver = null;
		 try {	driver	= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String destinationScreenShot= utilities.captureScreenShot(driver, testName);
			extentTest.addScreenCaptureFromPath(destinationScreenShot);
			extentTest.log(Status.INFO, result.getThrowable());
			extentTest.log(Status.FAIL, testName+"failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.SKIP,testName+"Skipped");
		extentTest.log(Status.INFO, result.getThrowable());
		System.out.println(testName+"got Skipped");
		System.out.println(result.getThrowable());
	}

	
	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String pathOfExtentReport=".test-output/ExtentRepots/extentreport.html";
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
