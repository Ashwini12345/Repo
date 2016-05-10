package com.dolibar.pageobjectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dolibar.genericlib.Constants;
import com.dolibar.genericlib.Driver;

public class LoginToApp {
	
@FindBy(xpath="//input[@id='username']")
	private WebElement Username;
@FindBy(id="password")
    private WebElement password;
@FindBy(xpath="//input[@class='button']")
    private WebElement connection;


public void login(String username,String Password,String url){
	Driver.driver.get(url);
	Driver.driver.manage().window().maximize();
	Username.sendKeys(Constants.userId);
	password.sendKeys(Constants.password);
	connection.click();
}}