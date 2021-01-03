package com.qa.spicejet.utils;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.qa.spicejet.pages.HomePage;

public class ElementUtil {
	WebDriver driver;
	WebDriverWait wait;

	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Constants.DEFAULT_TIMEOUT);
	}
	public String doGetTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public WebElement doGetElement(By locator) {
		WebElement element=null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Spme exception got occured while creating element");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	public boolean doIsDisplayed(By locator) {
		 try {
			return doGetElement(locator).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void doActionSendKeys(By locator, String value) {
		try {
			Actions action=new Actions(driver);
			WebElement elem=doGetElement(locator);
			elem.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			action.sendKeys(elem, value).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Some exceptionm got occured while entering values");
			e.printStackTrace();
		}
	}
	public void doSendKeys(By locator,String value) {
		try {
			WebElement ele=doGetElement(locator);
			ele.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			ele.sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doClick(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
