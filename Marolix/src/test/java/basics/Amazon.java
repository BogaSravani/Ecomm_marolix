package basics;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in/");
	driver.navigate().refresh();
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	List<WebElement> phones=driver.findElements(By.xpath("//div[contains(@aria-label,'iphone')]"));
	System.out.println(phones.size());
	for(WebElement phone:phones)
	{
		String text=phone.getText();
		 System.out.println(phone.getText());
		 if(text.contains("iphone 14"))
		 {
			 
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(phone));
		 	phone.click();
		 	break;
		 }
		 
	}
/**Iterator<WebElement> phone=phones.iterator();
while(phone.hasNext())
{
	String name= phone.next().getText();
	System.out.println(name);
	if(name.contains("iphone 14"))
	{
		  phone.next().click();
		break;
	}
}**/
	 
 
	 
}
}