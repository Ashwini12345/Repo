package com.vtiger.Campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vtiger.PageObjectRepository.CampaignCreate;
import com.vtiger.PageObjectRepository.LoginToApp;
import com.vtiger.genericlib.Constants;
import com.vtiger.genericlib.Driver;
import com.vtiger.genericlib.WebdriverCommonLib;

public class Campaign {
	WebDriver d=Driver.getBrowser();
	
	@BeforeClass()
		public void beforeClass(){
			WebdriverCommonLib lib=new WebdriverCommonLib();
			lib.waitForPageToLoad();
		}
	@BeforeMethod()
	public void beforeMethod(){
		LoginToApp login=PageFactory.initElements(d, LoginToApp.class);
		login.LoginToApp(Constants.userId, Constants.password, Constants.url);
	}
	@Test()
	public void create(){
		CampaignCreate c=PageFactory.initElements(d, CampaignCreate.class);
		c.campaigncreate("Road");
	}
	

}
