package com.qa.spicejet.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.spicejet.base.BasePage;
import com.qa.spicejet.utils.ElementUtil;

public class SelectOriginPage extends BasePage {
private WebDriver driver;
		ElementUtil elementUtil;
		ModifyingEntries modify;

	
	//By Locators
	By originStation=By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]");
	By destinStation=By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]");
	By datePicker=By.id("ui-datepicker-div");
	By passenger=By.xpath("//div[@class='row1 adult-infant-child']");
	By currency=By.xpath("//div[@class='row1 adult-infant-child']");
	By searchButton=By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']");
	By visibilityOfBook=By.xpath("//a[@id='highlight-book']");
	
	//LoginPage Class constructor
	
	public SelectOriginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//Page Actions
	public String verifyTitle() {
		String title=elementUtil.doGetTitle();
		System.out.println("originpageee"+ title);
		return title;
	}
	
	public boolean visibilityOfBook() {
		return elementUtil.doIsDisplayed(visibilityOfBook);
	}
	
	public void validEntries(String originStation, String destinStation) {
		elementUtil.doSendKeys(this.originStation, originStation);
		elementUtil.doSendKeys(this.destinStation, destinStation);
	}
	
	public void datePicker() {
		elementUtil.doClick(datePicker);
			//driver.findElement(By.id("ui-datepicker-div")).click();
			WebElement DateWidget = driver.findElement(By.id("ui-datepicker-div"));
			List<WebElement> columnst = DateWidget.findElements(By.tagName("td"));
			
			for (WebElement cellin: columnst)
			{
				if (cellin.getText().equals("31"))
				{
					cellin.findElement(By.linkText("31")).click();
					break;
				}
			}
	}
	public ModifyingEntries passengerEntries() {
		elementUtil.doClick(passenger);
		//driver.findElement(By.xpath("//div[@class='row1 adult-infant-child']")).click();
		driver.findElement(By.xpath("//select[@name='ctl00$mainContent$ddl_Adult']/child::option[@value='1']")).click();
		//driver.findElement(By.xpath("//select[@name='ctl00$mainContent$ddl_Child']/child::option[@value='1']")).click();
		//driver.findElement(By.xpath("//select[@name='ctl00$mainContent$ddl_Infant']/child::option[@value='1']")).click();
		
		driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']/child::option[@value='INR']")).click();
		elementUtil.doClick(searchButton);
		return new ModifyingEntries(driver);
}
}
