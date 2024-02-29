package com.opencart.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Opencart.qa.utils.utilities;

public class Base {
	  WebDriver driver;
	  public Properties prop;
	  public Properties dataprop;
	  public Base() {
		   prop = new Properties();
		  File file = new File("./src/main/java/com/Opencart/qa/config/config.properties");
		  try {
			  FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  dataprop = new Properties();
		  File datafile = new File("./src/main/java/com/Opencart/qa/testdata/testdata.properties");
		  try {
			FileInputStream datastream = new FileInputStream(datafile);
			dataprop.load(datastream);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
			 
	  } 
		    
	public WebDriver intilizeBrowser( String browsername ) {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();	
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PAGE_LOAD_TIME));
		
	return driver;}
	public void close(){
		driver.quit();
	
	}
}
