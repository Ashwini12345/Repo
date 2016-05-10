package com.vtiger.Campaigns;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class CreateCampaign {
	
	WebDriver d=new FirefoxDriver();
	
	 @BeforeClass(groups={"Regression"})
	  public void beforeClass() {
		 d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 d.get("http://localhost:8888/index.php?action=Login&module=Users");
	  }
	 @BeforeMethod(groups={"Regression"})
	  public void beforeMethod() throws EncryptedDocumentException, InvalidFormatException, IOException {
		 FileInputStream fis=new FileInputStream("C:\\Users\\ash\\Desktop\\TestData.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet("Sheet1");
			Row row=sh.getRow(1);
			String username=row.getCell(1).getStringCellValue();
			String Password=row.getCell(2).getStringCellValue();
		
			System.out.println(username);
			System.out.println(Password);
			
		 d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		 d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		 d.findElement(By.xpath("//input[@id='submitButton']")).click();
	  }

  @Test(groups={"Regression"})
  public void CreateCampaign() {
	  Actions act = new Actions(d);
		WebElement wb1=d.findElement(By.xpath("//a[text()='More']"));
		act.moveToElement(wb1).perform();
		d.findElement(By.xpath("//a[text()='Campaigns']")).click();
	    d.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	    d.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("Roadshow");
	    d.findElement(By.xpath("//img[@id='jscal_trigger_closingdate']")).click();
	    while(true){
	    	try{
	    		d.findElement(By.xpath("//thead[tr[td[text()='February, 2016']]]/following-sibling::tbody/tr[1]/td[8]")).click();
	    		break;
	    	}
	    	catch(Throwable t){
	    		d.findElement(By.xpath("//td[text()='Today']/following-sibling::td[1]")).click();
	    	}
	    }
	    d.findElement(By.xpath("(//input[@class='crmButton small save'])[1]")).click();
	    }
  
  @AfterMethod(groups={"Regression"})
  public void afterMethod() {
	  Actions act1=new Actions(d);
	  act1.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	    d.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
  }
  @AfterClass(groups={"Regression"})
  public void afterClass() {
	  d.quit();
  }

}
