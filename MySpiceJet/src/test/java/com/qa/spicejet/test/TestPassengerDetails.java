package com.qa.spicejet.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.spicejet.base.BasePage;
import com.qa.spicejet.pages.ModifyingEntries;
import com.qa.spicejet.pages.PassengerDetailPage;
import com.qa.spicejet.pages.SelectOriginPage;
import com.qa.spicejet.utils.Constants;

public class TestPassengerDetails {
	WebDriver driver;
	BasePage basePage;
	SelectOriginPage page1;
	ModifyingEntries page2;
	PassengerDetailPage page3;
	Properties prop;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage=new BasePage();
		prop=basePage.init_properties();
		driver=basePage.init_driver(prop);
		page1=new SelectOriginPage(driver);
		page1.validEntries(prop.getProperty("originStation"), prop.getProperty("destinStation"));
		page1.datePicker();
		page2=page1.passengerEntries();
		page2.clickOnModifyingButton();
		page2.dateModif();
		page3=page2.placeModify();
	}
	@Test(priority=1)
	public void passengerDetailsPageTitleTest() {
		String title=page3.getTitleOfPage3();
		System.out.println(title);
		Assert.assertEquals(title, Constants.PASSENGER_DETAILS_PAGE_TITLE);
	}
	@Test(priority=2)
	public void contactDetailsTest() {
		page3.validEntries(prop.getProperty("phoneNum"), prop.getProperty("email"));
	}
	@Test(priority=3)
	public void testPassDetails() {
		page3.passengerDetails();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=4)
	public void contactDetailsRepeatTest() {
		page3.contactDetailsRepeat(prop.getProperty("phoneNumRepeat"));
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
	
	
}
