package basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;
public class Orange {
	public static void main(String[] args) throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications--");
		 WebDriver driver=new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin",Keys.TAB,"admin123",Keys.ENTER);
	     driver.findElement(By.xpath("//span[text()='Admin']")).click();
		 driver.findElement(By.xpath("//i[contains(@class,'oxd-button-icon')]")).click();
		/** driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[1]")).click();
		 String mainid=driver.getWindowHandle();
		 Set<String> ids=driver.getWindowHandles();
		 for(String id:ids)
		 {
			 if(!mainid.equals(id))
			 {
				 driver.switchTo().window(id);
			 }
		 }**/
		 
		driver.findElement(By.xpath("//div[contains(@class,'oxd-select-text--active')][1]")).click();
		 Robot r=new Robot();
		 r.keyPress(KeyEvent.VK_DOWN);
		 r.keyRelease(KeyEvent.VK_DOWN);
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//div[contains(@class,'oxd-select-text--active')]/div[1]")).click();
		 Robot r2=new Robot();
		 r2.keyPress(KeyEvent.VK_DOWN);
		 r2.keyRelease(KeyEvent.VK_DOWN);
		 r2.keyPress(KeyEvent.VK_ENTER);
		 r2.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Jacqueline  White");
		r.keyPress(KeyEvent.VK_DOWN);
		 r.keyRelease(KeyEvent.VK_DOWN);
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
}

