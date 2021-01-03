package com.qa.spicejet.test;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.qa.spicejet.base.BasePage;
import com.qa.spicejet.pages.SelectOriginPage;
import com.qa.spicejet.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectingOriginPlacePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	SelectOriginPage originPage;
	//Constants constants;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage=new BasePage();
		
		prop=basePage.init_properties();
		
		driver=basePage.init_driver(prop);
		originPage=new SelectOriginPage(driver);
	}
	@Test
	public void SelectOriginPageTitleTest() {
		String title=originPage.verifyTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.SELECT_ORIGIN_PAGE_TITLE);
	}
	@Test
	public void verifyVisibilityOfBookLinkTest() {
		boolean b=originPage.visibilityOfBook();
		System.out.println(b);
		Assert.assertTrue(b);
	}
	@Test
	public void verifyEntriesTest() {
		originPage.validEntries(prop.getProperty("originStation"),prop.getProperty("destinStation"));
		originPage.datePicker();
		originPage.passengerEntries();
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
}
