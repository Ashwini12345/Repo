package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Generic.Driver;



public class LoginToApp {
	@FindBy(name="user_name")
	private WebElement userNameEdit;
   @FindBy(name="user_password")
   private WebElement passwordnameEdit;
   @FindBy(id="submitButton")
   private WebElement loginbutton;
   
   public void LoginToApp(String username,String password,String url){
	   Driver.driver.get(url);	
	   Driver.driver.manage().window().maximize();
	   userNameEdit.sendKeys(username);
	   passwordnameEdit.sendKeys(password);
	   loginbutton.click();
   }
}
