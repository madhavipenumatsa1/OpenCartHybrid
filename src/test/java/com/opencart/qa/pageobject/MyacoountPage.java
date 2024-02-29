package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyacoountPage {
	WebDriver driver;
@FindBy(xpath="//span[text()='My Account']")
WebElement MyAccountDropdown;

@FindBy(linkText = "Login")
WebElement LoginOption;

@FindBy(linkText="Register")
WebElement RegisterOption;

public MyacoountPage(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
}
	public void ClickonMydropdown() {
		MyAccountDropdown.click();
	}
	public LoginPages SelectLoginOption() {
		LoginOption.click();
		return  new LoginPages(driver);
	}
	public RegisterPage SelectRegisterOption() {
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
}

