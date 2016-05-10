package com.vtiger.TroubleTickets;

import org.testng.annotations.Test;

import com.vtiger.PageObjectRepository.LoginToApp;
import com.vtiger.genericlib.Constants;
import com.vtiger.genericlib.Driver;
import com.vtiger.genericlib.ExcelLib;
import com.vtiger.genericlib.WebdriverCommonLib;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class TroubleTickets {
	WebDriver d=Driver.getBrowser();
	
	 @BeforeClass
	  public void beforeClass(){
		 WebdriverCommonLib wlib=new WebdriverCommonLib();
		 wlib.waitForPageToLoad();
         d.get(Constants.url);
		 }
	  @BeforeMethod
	  public void beforeMethod() throws EncryptedDocumentException, InvalidFormatException, IOException {
		  //ExcelLib exel=new ExcelLib();
			 //String userName=exel.getExcelData("Sheet1", 1, 1);
			// String Password=exel.getExcelData("Sheet1", 1, 2);

			// d.findElement(By.xpath("//input[@name='user_na me']")).sendKeys(Constants.userId);
			 //d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Constants.password);
			// d.findElement(By.xpath("//input[@id='submitButton']")).click();
			 
			LoginToApp login=PageFactory.initElements(d, LoginToApp.class);
			login.LoginToApp(Constants.userId, Constants.password, Constants.url);
	  }
  @Test
  public void f() {
	  d.findElement(By.xpath("//a[text()='Trouble Tickets']")).click();
	  List<WebElement> List=d.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));
	  //List<WebElement> Lis1t=d.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[]/a"));

	  for(int i=1;i<List.size();i++){
		  for(int j=i+1;j<List.size();j++){
			  if(List.get(i).getText().equals(List.get(j).getText())){
				List<WebElement> List1=d.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[1]/input"));
				List1.get(i).click();
  }
	}
			d.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();

          Alert alt=d.switchTo().alert();
          alt.accept();
	  }
  }


  @AfterMethod
  public void afterMethod() {
  }

 

  @AfterClass
  public void afterClass() {
  }

}
