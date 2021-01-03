package com.qa.spicejet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.spicejet.utils.ElementUtil;

public class PaymentPage {
	WebDriver driver;
	ElementUtil elementUtil;
	//By locators
	By toPaymentPage=By.id("continue-to-payment-page");
	By seatSelection=By.xpath("//button[@class='buttonN middleSeatbtn ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'][position()=2]");
	By toAddOnsPage=By.id("continue-to-addons-page");
	public PaymentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String getPaymentPageTitle() {
		String title=driver.getTitle();
		System.out.println("paymentpage"+ title);
		return title;
	}
	public void payment() {
		//driver.findElement(By.id("continue-to-payment-page")).click();
		elementUtil.doClick(toPaymentPage);
		
		driver.findElement(By.id("0_Y_1_7C")).click();
		try {
			elementUtil.doClick(seatSelection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClick(toAddOnsPage);
		
}
}
