package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import Generic.Driver;



public class CampaignCreate {
	@FindBy(xpath="//a[text()='More']")
	private WebElement More;
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement Campaigns;
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaignButton;
	@FindBy(name="campaignname")
	private WebElement CampaignName;
	@FindBy(id="jscal_trigger_closingdate")
	private WebElement CalendarButton;
	@FindBy(xpath="//thead[tr[td[text()='February, 2016']]]/following-sibling::tbody/tr[1]/td[8]")
	private WebElement MonthDate;
	@FindBy(xpath="//td[text()='Today']/following-sibling::td[1]")
	private WebElement ArrowButton;
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement SaveButton;
	
	public void campaigncreate(String campaignname){
		Actions act=new Actions(Driver.driver);
		act.moveToElement(More).perform();
		Campaigns.click();
		createCampaignButton.click();
		CampaignName.sendKeys(campaignname);
		CalendarButton.click();
		 while(true){
		    	try{
		    		MonthDate.click();
		    		break;
		    	}
		    	catch(Throwable t){
		    		ArrowButton.click();
		    	}
		    }
		 SaveButton.click();
		    }
	}


