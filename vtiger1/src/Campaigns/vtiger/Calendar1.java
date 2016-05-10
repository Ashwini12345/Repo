package Campaigns.vtiger;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Generic.Constants;
import Generic.Driver;
import Generic.WebdriverCommonLib;
import PageObject.Calendarvtiger;
import PageObject.LoginToApp;



public class Calendar1 extends WebdriverCommonLib {
	WebDriver d=Driver.getBrowser();
	String todoname="Kisan suvidha2";
@BeforeClass()
public void beforeClass(){
	waitForPageToLoad();
	
}
@BeforeMethod()
public void beforeMethod(){
	LoginToApp login=PageFactory.initElements(d, LoginToApp.class);
	login.LoginToApp(Constants.userId, Constants.password, Constants.url);
}
@Test()
public void Calendartimetest(){
	Calendarvtiger cal=PageFactory.initElements(d, Calendarvtiger.class);
cal.select(todoname);
List<WebElement> list=Driver.driver.findElements(By.xpath("//table[@class='small']/tbody/tr/following-sibling::tr[2]/td[5]/a"));
for(int i=0;i<=list.size()-1;i++){
	String actval=list.get(i).getText();
	System.out.println(actval);
	Assert.assertEquals(actval.equals(todoname),true);
	
}

}

}
