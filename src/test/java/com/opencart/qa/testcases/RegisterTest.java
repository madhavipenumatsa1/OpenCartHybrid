package com.opencart.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Opencart.qa.utils.utilities;
import com.opencart.qa.base.Base;
import com.opencart.qa.pageobject.AccountPages;
import com.opencart.qa.pageobject.MyacoountPage;
import com.opencart.qa.pageobject.RegisterPage;

public class RegisterTest extends Base {
public 	WebDriver driver;
	RegisterPage registerpage;
	public RegisterTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		driver = intilizeBrowser(prop.getProperty("browsername"));
		MyacoountPage accountpage = new MyacoountPage(driver);
		accountpage.ClickonMydropdown();
		 registerpage	= accountpage.SelectRegisterOption();
		
	}
	@AfterMethod
	public void teardown() {
		close();
	}
	@Test(priority=1)
	public void ValidateRegisteringanAccountWiththeMandatoryfields() {
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(utilities.generateTimeStamp());
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterconformPassword(dataprop.getProperty("password"));
		registerpage.enterTelephoneNumber(dataprop.getProperty("phoneNumber"));
		registerpage.clickOnCheckBox();
		registerpage.clickOncontinueButton();
		AccountPages accountpages = new AccountPages(driver);
		
		String actualHeading =accountpages.checkaccountCreateMessage();
		Assert.assertEquals(actualHeading,dataprop.getProperty("expectedAccountHeading"),"Account creation error message");	
	}
	@Test(priority=2)
	public void VerifyRegisteringanAccountwithprovidingalldeatils() {
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(utilities.generateTimeStamp());
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterconformPassword(dataprop.getProperty("password"));
		registerpage.enterTelephoneNumber(dataprop.getProperty("phoneNumber"));
		registerpage.clickOnRadioButton();
		registerpage.clickOnCheckBox();
		registerpage.clickOncontinueButton();
		AccountPages accountpages = new AccountPages(driver);
		
		String actualHeading =accountpages.checkaccountCreateMessage();
		Assert.assertEquals(actualHeading,dataprop.getProperty("expectedAccountHeading"),"Account creation error message");	}
	@Test(priority=3)
	public void veridyRegisteringAccountwithoutProvidinAnyValues() {
		registerpage.clickOncontinueButton();

		String actualFirstname =registerpage.firstNameErrorMessage();
		Assert.assertEquals(actualFirstname, dataprop.getProperty("firstNameErrorMessage"),"Firstname error message");
		
		String actualLastname = registerpage.lastNameErrorMessage();
		Assert.assertEquals(actualLastname, dataprop.getProperty("lastNameErrorMessage"),"Lastname error message");
		
		String actualEmail = registerpage.emailErrorMessage();
		Assert.assertEquals(actualEmail, dataprop.getProperty("emailErrorMessage"),"Email error message");
		
		String actualTelephone = registerpage.telephoneErrorMessage();
		Assert.assertEquals(actualTelephone, dataprop.getProperty("telephoneErrorMessage"),"Telephone error message");
		
		String actualpassword = registerpage.passwordErrorMessage();
		Assert.assertEquals(actualpassword, dataprop.getProperty("passwordErrorMessage"),"Telephone error message");	
	}
	@Test(priority=4)
	public void verifytheRegisteringAccountByprovidingDifferentPasswords() {
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(utilities.generateTimeStamp());
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterconformPassword(dataprop.getProperty("12345"));
		registerpage.enterTelephoneNumber(dataprop.getProperty("phoneNumber"));
		registerpage.clickOnCheckBox();
		registerpage.clickOncontinueButton();
		String actualPasswordError =registerpage.passwordmismatchErrorMessage();
		Assert.assertEquals(actualPasswordError, dataprop.getProperty("passwordConformationErrorMessage"),"password conformation error message");
	}
	@Test(priority=5 , dependsOnMethods="verifytheRegisteringAccountByprovidingDifferentPasswords")
	public void verifytheRegisteringAccountByProvidingExistigEmail() {
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(prop.getProperty("username"));
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterconformPassword(dataprop.getProperty("password"));
		registerpage.enterTelephoneNumber(dataprop.getProperty("phoneNumber"));
		registerpage.clickOnCheckBox();
		registerpage.clickOncontinueButton();
		String actualHeading =registerpage.existingEmailErrorMEssage();
		Assert.assertEquals(actualHeading, dataprop.getProperty("existingEmailErrorMessage"),"email adress allerady exit error message");
		
	}
	@Test(priority=6)
	public void verifytheprivacypolicyCheckboxisnotSelectd() {
		Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected(),"privacyplocy checkbox error message");
     
	}
	@Test(priority=7)
	public void verifyRegisringAccountWothoutProvidingPrivacypolocy() {
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(utilities.generateTimeStamp());
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterconformPassword(dataprop.getProperty("password"));
		registerpage.enterTelephoneNumber(dataprop.getProperty("phoneNumber"));
		
		registerpage.clickOncontinueButton();
		String actualpeivacypolocy =registerpage.privacyPlocyErrorMessage();
		Assert.assertEquals(actualpeivacypolocy, dataprop.getProperty("privacyPolocyErrorMessage"),"privacypolocy  error message");
	}
	@Test(priority=8)
	public void verifyRegesteringAccountWithoutProvidingConformationPassword() {
		registerpage.enterFirstName(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(utilities.generateTimeStamp());
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterTelephoneNumber(dataprop.getProperty("phoneNumber"));
		registerpage.clickOnCheckBox();
		registerpage.clickOncontinueButton();
		String actualConformationpasswordError =registerpage.passwordErrorMessage();
		Assert.assertEquals(actualConformationpasswordError, dataprop.getProperty("passwordConformationErrorMessage"),"Conforamtion password  error message");
	}

	

}
