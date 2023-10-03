package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {
public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//button[text()='Prompt']")).click();
	//driver.switchTo().alert().sendKeys("tommy");
	driver.switchTo().alert().accept();
 
	WebElement wb=driver.findElement(By.xpath("//button[text()='Copy Text']"));
	Actions act=new Actions(driver);
	//act.scrollByAmount(0,800).perform();
	//act.scrollByAmount(0, 300).perform();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	act.doubleClick(wb).perform();
	WebElement src=driver.findElement(By.id("draggable"));
	WebElement des=driver.findElement(By.id("droppable"));
	act.dragAndDrop(src, des).perform();
	
}
}

