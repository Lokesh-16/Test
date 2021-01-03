package com.qa.spicejet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.spicejet.base.BasePage;
import com.qa.spicejet.utils.ElementUtil;

public class ModifyingEntries extends BasePage{
	WebDriver driver;
	PassengerDetailPage page3;
	ElementUtil elementUtil;
	
	public ModifyingEntries(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//Page Actions
		public String verifyTitle() {
		String title=driver.getTitle();
		System.out.println("modify:-"+ title);
		return title;
		}
	public void clickOnModifyingButton()  {

		driver.findElement(By.xpath("//span[@class='trip-modify-btn']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("YESSSSSSSSSSSSSS");
	}
	public void dateModif()  {
		WebElement DateModify = driver.findElement(By.xpath("//span[@id='custom_date_picker_1']"));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", DateModify);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//a[text()='1'])[1]")).click();
	}
	public PassengerDetailPage placeModify() {
		WebElement goButton=driver.findElement(By.xpath("//input[@id='AvailabilitySearchInputSelectView_ButtonSubmit']"));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", goButton);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[@class='button-continue-text']")).click();	
		return new PassengerDetailPage(driver);
	}
}