package com.qa.spicejet.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
		WebDriver driver;
		Properties prop;
		
		
		public WebDriver init_driver(Properties prop) throws InterruptedException {
			String browserName=prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}else {
				System.out.println("Enter correct browser name");
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
//			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			Thread.sleep(3000);
			return driver;
		}
		
		public Properties init_properties() {
			prop=new Properties();
			try {
				FileInputStream ip=new FileInputStream("C:\\Users\\toshiba\\MySpiceJet\\src\\main\\java\\com\\qa\\spicejet\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return prop;
		}
		
		
}
