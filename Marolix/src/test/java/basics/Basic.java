package basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Basic {
public static  void main(String[] args) throws AWTException {
	 
	 WebDriver driver=new  ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://testautomationpractice.blogspot.com/");
	 driver.findElement(By.id("name")).sendKeys("sravani",Keys.TAB,"sravanib.marolix@gmail.com",Keys.TAB,"6281619490",Keys.TAB,"kadapa,AP",Keys.TAB);
     driver.findElement(By.id("male")).click();
    List<WebElement> days= driver.findElements(By.xpath("//div[@class='form-group']/div/input[@type='checkbox' and @id]"));
     int day=days.size();
     for(int i=1;i<=day-1;i++)
     {
    	 for(WebElement dy:days)
    	 {
    		 days.get(i).click();
    		 System.out.println(dy.getText());
    	 }
     }
     WebElement wb=driver.findElement(By.id("country"));
    Select s=new Select(wb);
    s.selectByVisibleText("India");
    WebElement wb1=driver.findElement(By.id("colors"));
    Select s1=new Select(wb1);
    s1.selectByValue("red");
    s1.selectByValue("green");
   List<WebElement> wb2=s1.getAllSelectedOptions();
   for(WebElement wb3:wb2)
   {
	   System.out.println(wb3.getText());
   }
	driver.findElement(By.id("datepicker")).click();
	String month="December";
	String year="2024";
	String date="13";
	while(true)
	{
	String monthyear=driver.findElement(By.className("ui-datepicker-title")).getText();
	 String[] month_year=monthyear.split(" ");
String mnth=month_year[0];
	String yr=month_year[1];
	if(mnth.equalsIgnoreCase(month)&&yr.equals(year))
	{
		break;
	}
	else  
	{
	//	driver.findElement(By.xpath("//span[text()='Prev']")).click();
		
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	}
  
 Actions act=new Actions(driver);
 WebElement wb3=driver.findElement(By.linkText("orange HRM"));
 act.contextClick(wb3).perform();
 //act.keyUp(Keys.DOWN).perform();
 //act.keyDown(Keys.DOWN).click().perform();
 Robot r=new Robot();
 r.keyPress(KeyEvent.VK_DOWN);
 r.keyRelease(KeyEvent.VK_DOWN);
 r.keyPress(KeyEvent.VK_ENTER);
 r.keyRelease(KeyEvent.VK_ENTER);
 //act.click().perform();
 
 
 //driver.switchTo().parentFrame();
 driver.findElement(By.partialLinkText("open cart")).click();
 String mainid=driver.getWindowHandle();
 Set<String> ids=driver.getWindowHandles();
 for(String id:ids)
 {
	 driver.switchTo().window(id);
 }
 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin",Keys.TAB,"admin123",Keys.ENTER);
  driver.findElement(By.className("oxd-userdropdown-name")).click();
  driver.findElement(By.linkText("Logout")).click();
  driver.switchTo().window(mainid);
  driver.navigate().back();
  List<WebElement> rows=driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td[text()>500]"));
  for(WebElement row:rows)
  {
	  System.out.println(row.getText());
  }
 
 /** List<WebElement> prices=driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr/td[4]"));
  for(WebElement price:prices)
  {
	    WebElement pr=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr/td[3][text()='$10.99']"));
	    String text=pr.getText();
	    if(text.contains("$10.99"))
	    {
	    	price.click();
	    }
	    System.out.println("clicked");
  }**/
  
		 }
}
