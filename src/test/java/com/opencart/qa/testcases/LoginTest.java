package com.opencart.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Opencart.qa.utils.utilities;
import com.opencart.qa.base.Base;
import com.opencart.qa.pageobject.LoginPages;
import com.opencart.qa.pageobject.MyacoountPage;

public class LoginTest extends Base {
	LoginPages	loginpage;
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=intilizeBrowser(prop.getProperty("browsername"));
		MyacoountPage accountpage = new MyacoountPage(driver);
		accountpage.ClickonMydropdown();
			loginpage	= accountpage.SelectLoginOption();
	}
	@AfterMethod
	public void teardown() {
		close();
	}
	@Test(priority=1 ,dataProvider  ="valid credential supplier")
	public void LoginWithValidCredentials(String username, String password) {
		loginpage.login(username, password);	
	}
	@DataProvider(name ="valid credential supplier")
	public Object[][]  supplydata() {
		Object data[][]= utilities.generateRaddataFromExcelFile("Sheet1");
		return data;
		
	}
	@Test(priority=2)
	public void LoginWithValidEmailInvalidPassword() {
		loginpage.login(prop.getProperty("username"), dataprop.getProperty("WrongPassword"));
		String actualEmailAndPasswordError = loginpage.EmailAndPasswordErrorMessage();
		Assert.assertEquals(actualEmailAndPasswordError,dataprop.getProperty("emailAndPasswordErrorMessage"),"invalidpasswordErrorMEssage");
	}
	@Test(priority=3)
	public void LoginwithInvalidEmailValidPassword() {
		loginpage.login(utilities.generateTimeStamp(), prop.getProperty("password"));
		String actualEmailAndPasswordError = loginpage.EmailAndPasswordErrorMessage();
		Assert.assertEquals(actualEmailAndPasswordError,dataprop.getProperty("emailAndPasswordErrorMessage"),"invalidEmailErrorMEssage");
	}
	@Test(priority=4)
	public void LoginwithInvalidDetails() {
		loginpage.login(utilities.generateTimeStamp(), dataprop.getProperty("WrongPassword"));
		String actualEmailAndPasswordError = loginpage.EmailAndPasswordErrorMessage();
		Assert.assertEquals(actualEmailAndPasswordError,dataprop.getProperty("emailAndPasswordErrorMessage"),"invalidEmailAndPAsswordErrorMEssage");
	}
	@Test(priority=5)
	public void LoginWithEmptyDetails() {
		loginpage.clickOnLoginButton();
		String actualEmailAndPasswordError = loginpage.EmailAndPasswordErrorMessage();
		Assert.assertEquals(actualEmailAndPasswordError,dataprop.getProperty("emailAndPasswordErrorMessage"),"invalidEmailAndPAsswordErrorMEssage");
	}
	@Test(priority=6)
	public void verifyLoginBrwserbackFunctionality() {
		driver.navigate().back();
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,prop.getProperty("url"),"Verifyemail");
	}
	

}
