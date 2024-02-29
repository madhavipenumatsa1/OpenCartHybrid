package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
	WebDriver driver;
@FindBy(id="input-email")
private WebElement UsernameField;
@FindBy(id="input-password")
 private WebElement passwordField;
@FindBy(xpath="//input[@type='submit']")
private WebElement loginButton;
@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
private WebElement EmailAndPAsswordError;

public LoginPages(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void login(String email,String pwd) {
	UsernameField.sendKeys(email);
	passwordField.sendKeys(pwd);
	loginButton.click();
}
public void clickOnLoginButton() {
	loginButton.click();
}
public String EmailAndPasswordErrorMessage() {
return	EmailAndPAsswordError.getText();
}
}
