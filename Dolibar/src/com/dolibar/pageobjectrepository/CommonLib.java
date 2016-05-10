package com.dolibar.pageobjectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonLib {
@FindBy(xpath="//span[text()='Third parties']")
private WebElement Thirdparties;
@FindBy(xpath="//span[text()='Products/Services']")
private WebElement productsSevices;
@FindBy(xpath="//span[text()='Commercial']")
private WebElement commercial;
@FindBy(xpath="//span[text()='Financial']")
private WebElement financial;
@FindBy(xpath="//span[text()='Bank/Cash']")
private WebElement bankcash;
@FindBy(xpath="//span[text()='Projects']")
private WebElement projects;
@FindBy(xpath="//span[text()='Tools']")
private WebElement tools;
@FindBy(xpath="//span[text()='Agenda']")
private WebElement agenda;
@FindBy(xpath="//img[@class='login']")
private WebElement Logout;
public WebElement getThirdparties() {
	return Thirdparties;
}

public WebElement getProductsSevices() {
	return productsSevices;
}

public WebElement getCommercial() {
	return commercial;
}

public WebElement getFinancial() {
	return financial;
}

public WebElement getBankcash() {
	return bankcash;
}

public WebElement getProjects() {
	return projects;
}

public WebElement getTools() {
	return tools;
}

public WebElement getAgenda() {
	return agenda;
}


}
