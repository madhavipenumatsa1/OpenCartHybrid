package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
@FindBy(id="input-firstname")
private WebElement firstNameField;
@FindBy(id="input-lastname")
private WebElement lastNameField;
@FindBy(id="input-email")
private WebElement EmailField;
@FindBy(id="input-password")
private WebElement PasswordField;
@FindBy(id="input-confirm")
private WebElement passwordConfirmField;
@FindBy(id="input-telephone")
private WebElement telephoneField;
@FindBy(xpath="//input[@type='checkbox']")
private WebElement checkboxField;
@FindBy(xpath="//input[contains(@class,'btn-primary')]")
private WebElement ContinueButton;
@FindBy(xpath="//input[@name='newsletter'][@value='1']")
private WebElement radioButtonField;
@FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
private WebElement firstnameerror;
@FindBy(xpath="//div[text()='Last Name must be between 1 and 32 characters!']")
private WebElement lastnameError;
@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
private WebElement emailError;
@FindBy(xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
private WebElement telephoneError;
@FindBy(xpath="//div[text()='Password must be between 4 and 20 characters!']")
private WebElement passworderror;
@FindBy(xpath="//div[text()='Password confirmation does not match password!']")
private WebElement passwordmismatch;
@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
private WebElement existingemailError;
@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
private WebElement privacypolocyError;
public RegisterPage(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
	
}
public void enterFirstName(String firstname) {
	firstNameField.sendKeys(firstname);
}
	public void enterLastName(String lastname) {
		lastNameField.sendKeys(lastname);	
	}
	public void enterEmail(String email) {
		EmailField.sendKeys(email);
	}
	public void enterPassword(String password) {
		PasswordField.sendKeys(password);	
	}
	public void enterconformPassword(String conformpwd) {
		passwordConfirmField.sendKeys(conformpwd);
	}
	public void enterTelephoneNumber(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	public void clickOnCheckBox() {
		checkboxField.click();
	}
	public void clickOncontinueButton() {
		ContinueButton.click();
	}
	public void clickOnRadioButton() {
		radioButtonField.click();
	}
	public String firstNameErrorMessage() {
	return	firstnameerror.getText();
	}
	public String lastNameErrorMessage() {
		return lastnameError.getText();
	}
	public String emailErrorMessage() {
	return	emailError.getText();
	}
	public String telephoneErrorMessage() {
		return telephoneError.getText();
	}
	public String passwordErrorMessage() {
		return passworderror.getText();
	}
	public String passwordmismatchErrorMessage() {
		return passwordmismatch.getText();
	}
	public String existingEmailErrorMEssage() {
		return existingemailError.getText();
	}
	public String privacyPlocyErrorMessage() {
		return privacypolocyError.getText();
	}
	
	
	
	
	
	
	
}



