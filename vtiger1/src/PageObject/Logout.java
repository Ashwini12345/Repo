package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Generic.Driver;



public class Logout {
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement Administrator;

@FindBy(xpath="//a[text()='Sign Out']")
private WebElement Signout;

public void logout(){
	Actions act=new Actions(Driver.driver);
	act.moveToElement(Administrator).perform();
	Signout.click();
}



}
