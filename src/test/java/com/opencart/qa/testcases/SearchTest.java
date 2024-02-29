package com.opencart.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.base.Base;
import com.opencart.qa.pageobject.SearchPages;

public class SearchTest extends Base {
	SearchPages	searchPages;
	WebDriver driver;
	@BeforeMethod
	public void Setup() {
		driver =intilizeBrowser(prop.getProperty("browsername"));	
	}
	@AfterMethod
	public void teardown() {
		close();
	}
	@Test(priority=1)
	public void validateSearchwithExistingProduct() {
		searchPages = new SearchPages(driver);
		searchPages.EnterSearchoptions(dataprop.getProperty("ExistingProduct"));
		searchPages.clickOnSearchButton();
	Assert.assertTrue(searchPages.productVisibility(),"product error message");
	}
	@Test(priority=2)
	public void validateSearchwithNonExistingProduct() {
		searchPages = new SearchPages(driver);
		searchPages.EnterSearchoptions(dataprop.getProperty("nonExistingProduct"));
		searchPages.clickOnSearchButton();
		String actulNoProduct=searchPages.productMismatchErrorMessages();
		Assert.assertEquals(actulNoProduct, dataprop.getProperty("productMismatchCriteria"),"product mismatch message");
	}
	@Test(priority=3)
	public void validateSearchwithoutProvidingproduct() {
		searchPages = new SearchPages(driver);
		searchPages.clickOnSearchButton();
		String actulNoProduct=searchPages.productMismatchErrorMessages();
		Assert.assertEquals(actulNoProduct, dataprop.getProperty("productMismatchCriteria"),"product mismatch message");	
	}
}
