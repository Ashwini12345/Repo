package com.vtiger.Salesorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.PageObjectRepository.LoginToApp;
import com.vtiger.PageObjectRepository.SaleOrderCreation;
import com.vtiger.genericlib.Constants;
import com.vtiger.genericlib.Driver;
import com.vtiger.genericlib.WebdriverCommonLib;
@Listeners(com.vtiger.listener.Listener.class)
public class CreateSalesOrder {
	WebDriver d=Driver.getBrowser();

	String salename="bike23";
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
	public void salesTest() throws InterruptedException{
	SaleOrderCreation sale=PageFactory.initElements(d, SaleOrderCreation.class);
	sale.salescreate(salename,10);
	String actval=Driver.driver.findElement(By.xpath("(//a[text()='"+salename+"'])[2]")).getText();
	Assert.assertEquals(actval.contains(salename),true);
	
}}
