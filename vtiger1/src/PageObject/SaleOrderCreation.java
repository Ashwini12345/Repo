package PageObject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Generic.Driver;
import Generic.WebdriverCommonLib;


public class SaleOrderCreation {
	@FindBy(xpath="//a[text()='More']")
	private WebElement More;
	@FindBy(xpath="//a[text()='Sales Order']")
	private WebElement SalesOrder;
	@FindBy(xpath="//img[@title='Create Sales Order...']")
	private WebElement createbutton;
	@FindBy(name="subject")
	private WebElement subject;
	@FindBy(xpath="(//img[@title='Select'])[3]")
	private WebElement Contactname;
	@FindBy(xpath="//a[text()='Mary Smith']")
	private WebElement name;
	@FindBy(xpath="(//img[@title='Select'])[4]")
	private WebElement OrganizationName;
	@FindBy(xpath="//a[@id='1']")
	private WebElement OrgName;
	@FindBy(xpath="//select[@name='sostatus']")
	private WebElement Status;
	@FindBy(xpath="//img[@title='Products']")
	private WebElement products;
	@FindBy(xpath="//a[@id='popup_product_52']")
	private WebElement productname;
	@FindBy(xpath="//input[@id='qty1']")
	private WebElement qty;
	@FindBy(xpath="(//input[@class='crmbutton small save'])[2]")
	private WebElement saveButton;
	@FindBy(xpath="(//a[text()='Sales Order'])[3]")
	private WebElement sales;
	 public void salescreate(String Subject,int quantity) throws InterruptedException{
		 Actions alt=new Actions(Driver.driver);
		 alt.moveToElement(More).perform();
		 SalesOrder.click();
		 createbutton.click();
		 subject.sendKeys(Subject);
		 
		 Contactname.click();
		 Set<String> set=Driver.driver.getWindowHandles();
		 Iterator<String> it=set.iterator();
		 String parent=it.next();
		 String child=it.next();
		 Driver.driver.switchTo().window(child);
		 WebdriverCommonLib lib=new WebdriverCommonLib();
		 lib.waitForPageToLoad();
		 name.click();
		 Alert al=Driver.driver.switchTo().alert();
		 al.accept();
		 Driver.driver.switchTo().window(parent);
		 
		 OrganizationName.click();
		 Set<String> set1=Driver.driver.getWindowHandles();
		 Iterator<String> it1=set1.iterator();
		 String parent1=it1.next();
		 String child1=it1.next();
		 lib.waitForPageToLoad();
		 Driver.driver.switchTo().window(child1);
		 OrgName.click();
		 Alert al1=Driver.driver.switchTo().alert();
		 al1.accept();
		 Driver.driver.switchTo().window(parent1);
		 Select sel=new Select(Status);
		 sel.selectByVisibleText("Delivered");
		 
		 products.click();
		 Set<String> set2=Driver.driver.getWindowHandles();
		 Iterator<String> it2=set2.iterator();
		 String parent2=it2.next();
		 String child2=it2.next();
		 Driver.driver.switchTo().window(child2);
		 lib.waitForPageToLoad();
		 productname.click();
		 Driver.driver.switchTo().window(parent2);
		 qty.sendKeys(String.valueOf(quantity));
		 Thread.sleep(2000);
		 saveButton.click();
		 lib.waitForPageToLoad();
		 sales.click();
		 
	 }

}
