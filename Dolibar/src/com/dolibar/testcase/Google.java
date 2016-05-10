package com.dolibar.testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Google {
	
	public static void main (String[] args){
	WebDriver d=new FirefoxDriver();
	d.get("https://www.google.co.in/?gfe_rd=cr&ei=REi8Voe4NurI8Af3s5yQDw&gws_rd=ssl");
	d.findElement(By.xpath("//div[@id='sb_ifc0']")).sendKeys("s");
	List<WebElement> lst=d.findElements(By.xpath("//ul[@role='listbox']/li/div/div[2]/b"));
	for(int i=0;i<lst.size();i++){
		System.out.println("s"+lst.get(i).getText());
	}
	}
}
