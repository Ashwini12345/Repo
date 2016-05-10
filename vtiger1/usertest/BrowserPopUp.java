package com.vtiger.usertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class BrowserPopUp {
  @Test(groups={"Regression"})
  public void f() {
	  FirefoxProfile p= new FirefoxProfile();
	  p.setPreference("browser.download.folderList", 1);
	  p.setPreference("browser.helperApps.neverAsk.openFile", "application/zip");
	  p.setPreference("browser.download.lastDir", "C:\\Users\\ash\\Downloads");
	  
	  WebDriver d = new FirefoxDriver(p);
	  d.get("http://www.seleniumhq.org/download/");
	  d.findElement(By.xpath("//td[text()='C#']/following-sibling::td[3]/a")).click();
	  
  }
}
