package com.vtiger.Opportunities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class Opportunity {
  @Test
  public void OpportunityCreate() throws EncryptedDocumentException, InvalidFormatException, IOException {
	  WebDriver d=new FirefoxDriver();
	  d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 d.get("http://localhost:8888/index.php?action=Login&module=Users");
		 FileInputStream fis=new FileInputStream("C:\\Users\\ash\\Desktop\\A.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet("Sheet1");
			Row row=sh.getRow(1);
			String username=row.getCell(1).getStringCellValue();
			String Password=row.getCell(2).getStringCellValue();
		
		
		 d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		 d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		 d.findElement(By.xpath("//input[@id='submitButton']")).click();
		 
		 d.findElement(By.xpath("//a[text()='Organizations']")).click();
		 
		 d.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 d.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Ashwini");
		 d.findElement(By.xpath("//img[@title='Select']")).click();
		 
		 java.util.Set<String> set=d.getWindowHandles();
		 Iterator <String> it=set.iterator();
		 String parent=it.next();
		 String child=it.next();
		 d.switchTo().window(child);
		 d.findElement(By.xpath("//a[text()='vtiger']")).click();
		 d.switchTo().window(parent);
		 d.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
  }
}
