package com.vtiger.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	public static WebDriver driver;
	public static WebDriver getBrowser(){
		if(Constants.browser.equals("ie")){
			System.setProperty("WebDriver.Ie.driver", "");
			driver=new InternetExplorerDriver();
			}
		else if(Constants.browser.equals("Chrome")){
			System.setProperty("WebDriver.Chrome.driver", "");
			driver=new ChromeDriver();
		}
		else{
			driver=new FirefoxDriver();
		}
		
		return driver;
		}

}
