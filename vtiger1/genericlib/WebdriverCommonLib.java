package com.vtiger.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverCommonLib {
public void waitForPageToLoad(){
	Driver.driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
}

public void WitForXathToPresent(String xpath){
	WebDriverWait wait=new WebDriverWait(Driver.driver,20);
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
}

public void waiForNamePresent(String wbname){
	WebDriverWait wait=new WebDriverWait(Driver.driver,20);
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(wbname)));
}

public boolean VarifyText(WebElement wb,String expectText){
	boolean flag=false;
	String actval=wb.getText();
	if(actval.equals(expectText)){
		flag=true;
	System.out.println(expectText+"dada is verified==Pass");
}else{
	System.out.println(expectText+"dada is verified==Fail");
}
	return flag;
}

public void AcceptAlert(){
	Alert alt=Driver.driver.switchTo().alert();
	alt.accept();
}
public void CancelAlert(){
	Alert alt=Driver.driver.switchTo().alert();
	alt.dismiss();
}
}

