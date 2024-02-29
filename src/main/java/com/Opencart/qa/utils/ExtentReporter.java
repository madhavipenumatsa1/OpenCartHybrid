package com.Opencart.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		ExtentReports extentReport = new ExtentReports();
		 File extentReportFile = new File(".//test-output//ExtentRepots//extentreport.html");
		 ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		 sparkReporter.config().setTheme(Theme.DARK);
		 sparkReporter.config().setDocumentTitle("OpenCart automation Results");
		 sparkReporter.config().setReportName("Opencart test automation Results");
		 sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
		 extentReport.attachReporter(sparkReporter);
		 
		 Properties configprop = new Properties() ;
		 File file = new File("./src/main/java/com/Opencart/qa/config/config.properties");
		 FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			configprop.load(fis);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentReport.setSystemInfo("ApplicationUrl", configprop.getProperty("url"));
		extentReport.setSystemInfo("Browsername", configprop.getProperty("browsername"));
		extentReport.setSystemInfo("email", configprop.getProperty("username"));
		extentReport.setSystemInfo("password", configprop.getProperty("password"));
		extentReport.setSystemInfo("Osname", System.getProperty("os.name"));
		extentReport.setSystemInfo("java version", System.getProperty("java.version"));
		extentReport.setSystemInfo("userName", System.getProperty("user.name"));
		
		return extentReport;

		 
		 
		 
		
	}

}
