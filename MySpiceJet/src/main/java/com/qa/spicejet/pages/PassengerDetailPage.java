package com.qa.spicejet.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.spicejet.base.BasePage;
import com.qa.spicejet.utils.ElementUtil;

public class PassengerDetailPage extends BasePage {
	WebDriver driver;
	PassengerDetailPage obj;
	MealSectionPage page4;
	ElementUtil elementUtil;
	Properties prop;
	
	//By Locators
	By firstName=By.xpath("//input[@name='CONTROLGROUPPASSENGER$ContactInputPassengerView$TextBoxFirstName']");
	By lastName=By.xpath("//input[@name='CONTROLGROUPPASSENGER$ContactInputPassengerView$TextBoxLastName']");
	By phoneNum=By.xpath("//input[@name='CONTROLGROUPPASSENGER$ContactInputPassengerView$TextBoxHomePhone']");
	By email=By.xpath("//input[@name='CONTROLGROUPPASSENGER$ContactInputPassengerView$TextBoxEmailAddress']");
	By countryCode=By.xpath("//select[@name='CONTROLGROUPPASSENGER$ContactInputPassengerView$DropDownListCountry']/child::option[@value='IN']");
	By contactCitiesList=By.xpath("//select[@name='contact_cities_list_india']/child::option[position()=11]");
	By firstNameRepeat=By.xpath("//input[@name='CONTROLGROUPPASSENGER$PassengerInputViewPassengerView$TextBoxFirstName_0']");
	By lastNameRepeat=By.xpath("//input[@name='CONTROLGROUPPASSENGER$PassengerInputViewPassengerView$TextBoxLastName_0']");
	By phoneNumRepeat=By.xpath("//input[@name='CONTROLGROUPPASSENGER$PassengerInputViewPassengerView$TextBoxEmailMobile_0']");
	By addOns=By.xpath("continue-to-addons-page");
	
	public PassengerDetailPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		//prop=new Properties();
	}
	

	public String getTitleOfPage3() {
		String title=elementUtil.doGetTitle();
		System.out.println("passengerpage"+ title);
		return title;
	}
	public void validEntries(String phoneNum, String email) {
		elementUtil.doSendKeys(this.phoneNum, phoneNum);//Here arguments passed are Locators and values
		elementUtil.doSendKeys(this.email, email);//Here arguments passed are Locators and values
	}
	public void contactDetailsRepeat(String phoneNumRepeat) {
		driver.findElement(firstNameRepeat).sendKeys("Lokesh");
		driver.findElement(lastNameRepeat).sendKeys("Naidu");
		elementUtil.doSendKeys(this.phoneNumRepeat, phoneNumRepeat);
		driver.findElement(By.id("continue-to-addons-page")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public MealSectionPage passengerDetails() {
		
		driver.findElement(firstName).sendKeys("Lokesh");
		driver.findElement(lastName).sendKeys("Naidu");
		driver.findElement(countryCode).click();
		driver.findElement(contactCitiesList).click();
		//validEntries(prop.getProperty("phoneNum"), prop.getProperty("email"));
		//contactDetailsRepeat(prop.getProperty("phoneNumRepeat"));//how to pass the arguments to match the above method"validEntries"
		return new MealSectionPage(driver);
	}

	
}
