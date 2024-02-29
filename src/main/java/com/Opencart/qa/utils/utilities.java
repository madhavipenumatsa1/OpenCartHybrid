package com.Opencart.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utilities {
	
	
	public static final int IMPLICT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=10;
	
 public  static String generateTimeStamp() {
	 Date date = new Date();
	 String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
	 return "madhavipenumatsa"+timeStamp+"@gmail.com";
 }
 public static Object[][] generateRaddataFromExcelFile(String sheetname) {
	 File file = new File("./src/main/java/com/Opencart/qa/testdata/OpencartTeatdata.xlsx");
	 XSSFWorkbook workbook = null;
	 try {
	 FileInputStream stream = new FileInputStream(file);
	  workbook = new XSSFWorkbook(stream);
	 }
	 catch(Throwable e) {
		 e.printStackTrace();
	 }
	 XSSFSheet sheet = workbook.getSheet(sheetname);
	 int rows = sheet.getLastRowNum();
	 int cols = sheet.getRow(0).getLastCellNum();
	 Object [][] data = new Object[rows][cols];
	 for(int i=0;i<rows;i++) {
	XSSFRow row	= sheet.getRow(i+1);
	for(int j=0;j<cols;j++) {
	XSSFCell cell 	= row.getCell(j);
	
	DataFormatter formate = new DataFormatter() ;
	
		data[i][j] = formate.formatCellValue(cell);
		
		
	}
	}
	return data;
	 }
 public static String captureScreenShot(WebDriver driver, String testName) {
	
	 TakesScreenshot ts =  (TakesScreenshot)driver;
	File sourceScreenShoot =ts.getScreenshotAs(OutputType.FILE);
	String destinationScreenShot = "./ScreenShot/"+testName+".png";
	try {
		FileHandler.copy(sourceScreenShoot,new File(destinationScreenShot));
	} catch (IOException e) {
		e.printStackTrace();
	}
	return destinationScreenShot;
 }
	 
	 
 
}
