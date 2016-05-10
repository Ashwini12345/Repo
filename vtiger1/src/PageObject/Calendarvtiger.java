package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Generic.Driver;
import Generic.WebdriverCommonLib;




public class Calendarvtiger extends WebdriverCommonLib{
@FindBy(xpath="(//a[text()='Calendar'])[1]")
private WebElement calendarclick;
@FindBy(xpath="//td[@class='calAddButton']")
private WebElement add;
@FindBy(xpath="//a[text()='To Do']")
private WebElement Todo;
@FindBy(xpath="//input[@name='task_subject']")
private WebElement ToDoinput;
@FindBy(xpath="//select[@id='taskstatus']")
private WebElement status;
@FindBy(xpath="(//select[@id='starthr'])[2]")
private WebElement Timehour;
@FindBy(xpath="(//select[@id='startmin'])[2]")
private WebElement Timemin;
@FindBy(xpath="//img[@id='jscal_trigger_task_date_start']")
private WebElement date;
@FindBy(xpath="//thead[tr[td[text()='July, 2016']]]/following-sibling::tbody/tr[2]/td[text()='6']")
private WebElement selectdate;
@FindBy(xpath="//td[text()='Today']/following-sibling::td[1]")
private WebElement arrowbutton;
@FindBy(xpath="(//input[@class='crm button small save'])[3]")
private WebElement save;
@FindBy(xpath="//a[text()='Year']")
private WebElement year;

public void select(String todo){
	calendarclick.click();
	waitForPageToLoad();
	Actions act=new Actions(Driver.driver);
	act.moveToElement(add).perform();
	Todo.click();
	waitForPageToLoad();
	ToDoinput.sendKeys(todo);
	
	Select sel=new Select(status);
	sel.selectByValue("In Progress");
	
	Select sel1=new Select(Timehour);
	sel1.selectByValue("04");
	
	Select sel2=new Select(Timemin);
	sel2.selectByValue("25");
	
	date.click();
	while(true){
		try{
			
		selectdate.click();
		break;
		}
		catch(Throwable e){
			arrowbutton.click();
		}
	}
	save.click();
	year.click();
	
}



}
