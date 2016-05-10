package com.vtiger.Salesorder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.PageObjectRepository.LoginToApp;
import com.vtiger.genericlib.Constants;
import com.vtiger.genericlib.Driver;
import com.vtiger.genericlib.WebdriverCommonLib;
@Listeners(com.vtiger.listener.Listener.class)
public class Salesorder1 {
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
public void Sales1Tset(){
	Actions act= new Actions(d);
	act.moveToElement(d.findElement(By.xpath("//a[text()='More']"))).perform();
	d.findElement(By.xpath("//a[text()='Sales Order']")).click();
	Select sel=new Select(d.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]")));
	sel.selectByVisibleText("Organization Name");
	
	List<WebElement> List1=d.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[2]/following-sibling::tr/td[1]/input"));
	try{
		
	for(int i=0;i<=List1.size()-1;i++){
		List1.get(i).click();
	}
	
}
	catch(Throwable e){
		e.printStackTrace();
	}

d.findElement(By.xpath("(//input[@class='crmbutton small edit' and @value='Mass Edit'])[1]")).click();

}}
