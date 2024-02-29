package com.opencart.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPages {
	WebDriver driver;
@FindBy(name="search")
WebElement searchfield;
@FindBy(xpath="//div[@id='search']//descendant::button[@type='button']")
WebElement searchButton;
@FindBy(linkText="iMac")
WebElement productVisible;
@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
WebElement productMismatchErrorMessage;
 public SearchPages(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
 }
 public void EnterSearchoptions(String iteams) {
	 searchfield.sendKeys(iteams);
 }
 public void clickOnSearchButton() {
	 searchButton.click();
 }
 public boolean productVisibility() {
	return productVisible.isDisplayed();
 }
 public String productMismatchErrorMessages() {
	 return productMismatchErrorMessage.getText();
 }
 
}
