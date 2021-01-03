package com.qa.spicejet.test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.spicejet.base.BasePage;
import com.qa.spicejet.pages.ModifyingEntries;
import com.qa.spicejet.pages.SelectOriginPage;
import com.qa.spicejet.utils.Constants;


public class ModifyingOriginPlacePageTest {
	WebDriver driver;
	BasePage basePage;
	SelectOriginPage page1;
	ModifyingEntries page2;
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
		//page1.validEntries(originStation, destinStation);
		//page2=page1.passengerEntries();
	}
	@Test
	public void modifyingOriginPlacePageTitleTest() {
		String title=page2.verifyTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.MODIFYING_ORIGINPLACE_PAGE_TITLE);
	}
	
	@Test(priority=2,enabled=false)
	public void clickOnModifyingButtonTest() {
		page2.clickOnModifyingButton();
	}
	@Test(priority=3,enabled=false)
	public void dateModifyingTest() {
		page2.dateModif();
	}
	@Test(priority=4,enabled=false)
	public void placeModifyingTest() {
		page2.placeModify();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
}
