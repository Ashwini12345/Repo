package com.dolibar.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dolibar.genericlib.Constants;
import com.dolibar.genericlib.Driver;
import com.dolibar.genericlib.WebdriverCommonLib;
import com.dolibar.pageobjectrepository.CommonLib;
import com.dolibar.pageobjectrepository.LoginToApp;

public class Login {
	WebDriver d=Driver.getBrowser();
	CommonLib lib=PageFactory.initElements(d, CommonLib.class);
@BeforeClass()
public void beforeclass(){
	WebdriverCommonLib lib=new WebdriverCommonLib();
	lib.waitForPageToLoad();
}
@Test()
public void logintest(){
	LoginToApp login=PageFactory.initElements(d, LoginToApp.class);
	login.login("erpadmin", "erpadmin", Constants.url);
lib.getProjects().click();
 
}


}
