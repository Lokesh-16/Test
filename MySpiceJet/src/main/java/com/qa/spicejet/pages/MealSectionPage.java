package com.qa.spicejet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.spicejet.utils.ElementUtil;

public class MealSectionPage {
	WebDriver driver;
	ElementUtil elementUtil;
	//By locators
	By hotMealBtn=By.xpath("//span[@class='inverse-margin-left-20']/child::input[@id='hotMealsBtn']");
	By mealPanelSelect=By.className("mealPanelSelect");
	By mealChk=By.className("mealChk");
	By mealPanelCloseBtn=By.xpath("//a[@class='mealpanel-close-btn buttonN'][position()=1]");
	
	public MealSectionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	public String getMealSectionPageTitle() {
		String title=elementUtil.doGetTitle();
		System.out.println("mealpage"+title);
		return title;
	}
	public PaymentPage mealSection() {
		elementUtil.doClick(hotMealBtn);
		elementUtil.doClick(mealPanelSelect);
		elementUtil.doClick(mealChk);
		elementUtil.doClick(mealPanelCloseBtn);
		return new PaymentPage(driver);
}
}
