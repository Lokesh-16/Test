package com.qa.spicejet.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.spicejet.base.BasePage;
import com.qa.spicejet.pages.MealSectionPage;
import com.qa.spicejet.pages.ModifyingEntries;
import com.qa.spicejet.pages.PassengerDetailPage;
import com.qa.spicejet.pages.SelectOriginPage;
import com.qa.spicejet.utils.Constants;

public class TestMealSectionPage {
	WebDriver driver;
	BasePage basePage;
	SelectOriginPage page1;
	ModifyingEntries page2;
	PassengerDetailPage page3;
	MealSectionPage page4;
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
		page3.validEntries(prop.getProperty("phoneNum"), prop.getProperty("email"));
		
		page4=page3.passengerDetails();
		page3.contactDetailsRepeat(prop.getProperty("phoneNumRepeat"));
	}
	@Test
	public void mealSectionPageTitleTest() {
		String title=page4.getMealSectionPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.MEAL_SECTION_PAGE_TITLE);
	}
	@Test(enabled=true)
	public void testMeal() {
		page4.mealSection();
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
