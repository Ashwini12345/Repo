import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Twitter {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://twitter.com/");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[text()='Log In']")).click();
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("@desai6Ashwini");
        driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("ashwinitwitter");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        driver.findElement(By.id("search-query")).click();
        driver.findElement(By.id("search-query")).sendKeys("POTUS");
        driver.findElement(By.xpath("//span[text()='President Obama']")).click();
       
        //driver.findElement(By.xpath("//button[@class='Icon Icon--search nav-search']")).click();
     
        //Actions act=new Actions(driver);
        //act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        //JavascriptExecutor js=(JavascriptExecutor)driver;
        
        WebElement wb1= driver.findElement(By.xpath("(//span[@class='button-text follow-text'])[1]"));
        //WebElement wb= driver.findElement(By.xpath("(//h3[@class='AdaptiveSearchPage-moduleTitle'])[2]"));
        
       // js.executeScript("arguments[0].scrollIntoView();", wb);
        wb1.click();
       // driver.findElement(By.id("user-dropdown-toggle")).click();
        //driver.findElement(By.xpath("//button[text()='Log out']")).click();
        System.out.println("pass");
	}

}
