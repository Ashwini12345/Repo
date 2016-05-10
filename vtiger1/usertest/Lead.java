package com.vtiger.usertest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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

public class Lead {
	WebDriver d=new FirefoxDriver();	
	
	@BeforeClass(groups={"Smoke"})
	  public void beforeClass() {
		 d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 d.get("http://localhost:8888/index.php?action=Login&module=Users");		
	  }
	@BeforeMethod(groups={"Smoke"})
	  public void beforeMethod() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
			 FileInputStream fis=new FileInputStream("C:\\Users\\ash\\Desktop\\A.xlsx");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sh=wb.getSheet("Sheet1");
				Row row=sh.getRow(1);
				String username=row.getCell(1).getStringCellValue();
				String Password=row.getCell(2).getStringCellValue();
			
				//System.out.println(username);
				//System.out.println(Password);
				
			 d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
			 d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
			 d.findElement(By.xpath("//input[@id='submitButton']")).click();
	  }
  @Test(groups={"Smoke"})
  public void Lead() {
	  d.findElement(By.xpath("//a[text()='Leads']")).click();
	  d.findElement(By.xpath("//td[text()='M']")).click();
	 List<WebElement> List =d.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[4]/a"));
	  for (int i = 0; i < List.size(); i++) {
		//System.out.println(List.get(i).getText());
		String Actval=List.get(i).getText();
		if(Actval.startsWith("M")){
			System.out.println(Actval);
		}
	}
  }
  
  

  @AfterMethod(groups={"Smoke"})
  public void afterMethod() {
	  Actions act1=new Actions(d);
	  act1.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	    d.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
  }

  

  @AfterClass(groups={"Smoke"})
  public void afterClass() {
	  d.quit();
  }

}
