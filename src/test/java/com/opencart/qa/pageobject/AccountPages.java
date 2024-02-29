package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPages {
WebDriver driver;
@FindBy(xpath="//div[@id='content']//h1[text()='Your Account Has Been Created!']")
WebElement AccountcreatedMessage;
 public AccountPages(WebDriver driver) {
	 this.driver= driver;
	 PageFactory.initElements(driver, this);
 }
 public String checkaccountCreateMessage() {
return	 AccountcreatedMessage.getText();
 }
}
